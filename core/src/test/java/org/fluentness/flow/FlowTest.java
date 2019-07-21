package org.fluentness.flow;

import org.fluentness.Fluentness;
import org.fluentness.base.generics.Provider;
import org.fluentness.flow.controller.ControllerProvider;
import org.fluentness.flow.repository.RepositoryProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class FlowTest {

    @Before
    public void setUp() {
        Fluentness.base.reset();
    }

    @Test(expected = NullPointerException.class)
    public void instantiateProvider_noClassIsGiven_nullPointerExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fluentness.flow.instantiateProvider(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void instantiateProvider_noClassNameIsGiven_nullPointerExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fluentness.flow.instantiateProvider(ControllerProvider.class, null);
    }

    @Test(expected = ClassNotFoundException.class)
    public void instantiateProvider_absentClassIsGiven_classNotFoundExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fluentness.flow.instantiateProvider(ControllerProvider.class, "this.class.does.not.Exist");
    }

    @Test
    public void instantiateProvider_normalProviderClassIsGiven_providerIsInstantiated()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Provider providerMock = mock(Provider.class);

        Provider provider = Fluentness.flow.instantiateProvider(
            providerMock.getClass(),
            providerMock.getClass().getCanonicalName()
        );
        Assert.assertNotNull(provider);
    }

    @Test(expected = ClassCastException.class)
    public void instantiateProvider_wrongProviderClassIsGiven_classCastExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ControllerProvider controllerProviderMock = mock(ControllerProvider.class);

        Fluentness.flow.instantiateProvider(
            RepositoryProvider.class,
            controllerProviderMock.getClass().getCanonicalName()
        );
    }

}
