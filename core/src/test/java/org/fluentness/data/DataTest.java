package org.fluentness.data;

public class DataTest {
//
//    @Before
//    public void setUp() {
//        Fluentness.getBase().setConfig(mock(DefaultConfigService.class));
//        Fluentness.getData().reset();
//    }
//
//    @Test
//    public void whenNothingIsDone_thenEntityManagerFactoryIsNotSet() {
//        Assert.assertNull(Fluentness.getData().getEntityManagerFactory());
//    }
//
//    @Test
//    public void whenDataIsInitialized_thenEntityManagerFactoryIsSetToItsDefaultImplementation() {
//        Fluentness.getData().initialize();
//
//        Assert.assertTrue(Fluentness.getData().getEntityManagerFactory() instanceof DefaultEntityManagerFactory);
//    }
//
//    @Test
//    public void whenCustomEntityManagerFactoryIsSetBeforehand_thenCustomEntityManagerFactoryIsGotAfterInitializing() {
//        EntityManagerFactory entityManagerFactory = mock(EntityManagerFactory.class);
//        Fluentness.getData().setEntityManagerFactory(entityManagerFactory);
//        Fluentness.getData().initialize();
//
//        Assert.assertFalse(Fluentness.getData().getEntityManagerFactory() instanceof DefaultEntityManagerFactory);
//    }
//
//    @Test(expected = PersistenceException.class)
//    public void whenDataIsInitializedWithAbsentPersistenceUnitConfig_thenPersistenceExceptionIsThrown() {
//        when(Fluentness.getBase().getConfig().has(PERSISTENCE_UNIT)).thenReturn(true);
//        when(Fluentness.getBase().getConfig().get(PERSISTENCE_UNIT)).thenReturn("absentPU");
//
//        Fluentness.getData().initialize();
//    }
//
//    @Test
//    public void whenDataIsInitializedWithPresentPersistenceUnitConfig_thenEntityManagerIsInitialized() {
//        when(Fluentness.getBase().getConfig().has(PERSISTENCE_UNIT)).thenReturn(true);
//        when(Fluentness.getBase().getConfig().get(PERSISTENCE_UNIT)).thenReturn("presentPU");
//        EntityManager entityManager = mock(EntityManager.class);
//        EntityManagerFactory entityManagerFactory = mock(EntityManagerFactory.class);
//        when(entityManagerFactory.get("presentPU")).thenReturn(entityManager);
//        Fluentness.getData().setEntityManagerFactory(entityManagerFactory);
//        Fluentness.getData().initialize();
//
//        Assert.assertNotNull(Fluentness.getData().getEntityManager());
//    }
}
