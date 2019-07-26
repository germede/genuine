package org.fluentness.flow;

import org.fluentness.Fluentness;
import org.fluentness.flow.provider.Provider;
import org.fluentness.flow.provider.ControllerProvider;
import org.fluentness.data.repository.RepositoryProducer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class FlowTest {

    @Before
    public void setUp() {
        Fluentness.getBase().reset();
    }

    @Test(expected = NullPointerException.class)
    public void instantiateProducer_noClassIsGiven_nullPointerExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fluentness.getFlow().instantiateProducer(null, null);
    }

    @Test(expected = NullPointerException.class)
    public void instantiateProducer_noClassNameIsGiven_nullPointerExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fluentness.getFlow().instantiateProducer(ControllerProvider.class, null);
    }

    @Test(expected = ClassNotFoundException.class)
    public void instantiateProducer_absentClassIsGiven_classNotFoundExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fluentness.getFlow().instantiateProducer(ControllerProvider.class, "this.class.does.not.Exist");
    }

    @Test
    public void instantiateProducer_normalProducerClassIsGiven_producerIsInstantiated()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Provider producerMock = mock(Provider.class);

        Provider producer = Fluentness.getFlow().instantiateProducer(
            producerMock.getClass(),
            producerMock.getClass().getCanonicalName()
        );
        Assert.assertNotNull(producer);
    }

    @Test(expected = ClassCastException.class)
    public void instantiateProducer_wrongProducerClassIsGiven_classCastExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ControllerProvider controllerProducerMock = mock(ControllerProvider.class);

        Fluentness.getFlow().instantiateProducer(
            RepositoryProducer.class,
            controllerProducerMock.getClass().getCanonicalName()
        );
    }

}
