package org.fluentness.flow;

import org.fluentness.Fluentness;
import org.fluentness.AbstractUnitTest;
import org.fluentness.base.generics.Provider;
import org.fluentness.flow.controller.ControllerProvider;
import org.fluentness.flow.repository.RepositoryProvider;
import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class FlowTest extends AbstractUnitTest {

    @Test(expected = NullPointerException.class)
    public void whenNoClassIsGiven_thenNullPointerExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fluentness.flow.instantiateProvider(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void whenNoClassNameIsGiven_thenNullPointerExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fluentness.flow.instantiateProvider(ControllerProvider.class, null);
    }

    @Test(expected = ClassNotFoundException.class)
    public void whenAbsentClassIsGiven_thenClassNotFoundExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fluentness.flow.instantiateProvider(ControllerProvider.class, "this.class.does.not.Exist");
    }

    @Test
    public void whenNormalProviderClassIsGiven_thenProviderIsInstantiated()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Provider providerMock = mock(Provider.class);

        Provider provider = Fluentness.flow.instantiateProvider(
            providerMock.getClass(),
            providerMock.getClass().getCanonicalName()
        );
        Assert.assertNotNull(provider);
    }

    @Test(expected = ClassCastException.class)
    public void whenWrongProviderClassIsGiven_thenClassCastExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ControllerProvider controllerProviderMock = mock(ControllerProvider.class);

        Fluentness.flow.instantiateProvider(
            RepositoryProvider.class,
            controllerProviderMock.getClass().getCanonicalName()
        );
    }

}
