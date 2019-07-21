package org.fluentness.data;

import org.fluentness.Fluentness;
import org.fluentness.IsolatedUnitTest;
import org.fluentness.base.config.Config;
import org.fluentness.data.entityManagerFactory.DefaultEntityManagerFactory;
import org.fluentness.data.entityManagerFactory.EntityManagerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import static org.fluentness.base.config.StringKey.PERSISTENCE_UNIT;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataTest extends IsolatedUnitTest {

    @Before
    public void setUp() {
        Fluentness.base.setConfig(mock(Config.class));
    }

    @Test
    public void whenNothingIsDone_thenEntityManagerFactoryIsNotSet() {
        Assert.assertNull(Fluentness.data.getEntityManagerFactory());
    }

    @Test
    public void whenDataIsInitialized_thenEntityManagerFactoryIsSetToItsDefaultImplementation() {
        Fluentness.data.initialize();

        Assert.assertTrue(Fluentness.data.getEntityManagerFactory() instanceof DefaultEntityManagerFactory);
    }

    @Test
    public void whenCustomEntityManagerFactoryIsSetBeforehand_thenCustomEntityManagerFactoryIsGotAfterInitializing() {
        EntityManagerFactory entityManagerFactory = mock(EntityManagerFactory.class);
        Fluentness.data.setEntityManagerFactory(entityManagerFactory);
        Fluentness.data.initialize();

        Assert.assertFalse(Fluentness.data.getEntityManagerFactory() instanceof DefaultEntityManagerFactory);
    }

    @Test(expected = PersistenceException.class)
    public void whenDataIsInitializedWithAbsentPersistenceUnitConfig_thenPersistenceExceptionIsThrown() {
        when(Fluentness.base.getConfig().has(PERSISTENCE_UNIT)).thenReturn(true);
        when(Fluentness.base.getConfig().get(PERSISTENCE_UNIT)).thenReturn("absentPU");

        Fluentness.data.initialize();
    }

    @Test
    public void whenDataIsInitializedWithPresentPersistenceUnitConfig_thenEntityManagerIsInitialized() {
        when(Fluentness.base.getConfig().has(PERSISTENCE_UNIT)).thenReturn(true);
        when(Fluentness.base.getConfig().get(PERSISTENCE_UNIT)).thenReturn("presentPU");
        EntityManager entityManager = mock(EntityManager.class);
        EntityManagerFactory entityManagerFactory = mock(EntityManagerFactory.class);
        when(entityManagerFactory.get("presentPU")).thenReturn(entityManager);
        Fluentness.data.setEntityManagerFactory(entityManagerFactory);
        Fluentness.data.initialize();

        Assert.assertNotNull(Fluentness.data.getEntityManager());
    }
}
