package org.fluentness.controller.web;

import org.fluentness.service.server.HttpMethod;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class WebControllerTest {

    private WebController webController;

    @Before
    public void setUp() {
        webController = new WebController();
    }

    @Test(expected = IOException.class)
    public void getActions() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<WebAction> actions = webController.getActions();

        Assert.assertEquals(actions.size(), 8);

        Assert.assertEquals(HttpMethod.GET, actions.get(1).getHttpMethod());
        Assert.assertEquals("/void", actions.get(1).getPath());
        Assert.assertEquals(webController.getClass().getMethod("testVoid"), actions.get(1).getMethod());

        Assert.assertEquals(HttpMethod.POST, actions.get(7).getHttpMethod());
        Assert.assertEquals("/testPostParameter", actions.get(7).getPath());
        Assert.assertEquals(webController.getClass().getMethod("testPostParameter"), actions.get(7).getMethod());

        actions.get(4).getMethod().invoke(webController);
    }

//    @Test(expected = NullPointerException.class)
//    public void instantiateProducer_noClassNameIsGiven_nullPointerExceptionIsThrown()
//        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        Fluentness.getFlow().instantiateProducer(ControllerProvider.class, null);
//    }
//
//    @Test(expected = ClassNotFoundException.class)
//    public void instantiateProducer_absentClassIsGiven_classNotFoundExceptionIsThrown()
//        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        Fluentness.getFlow().instantiateProducer(ControllerProvider.class, "this.class.does.not.Exist");
//    }
//
//    @Test
//    public void instantiateProducer_normalProducerClassIsGiven_producerIsInstantiated()
//        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        Provider producerMock = mock(Provider.class);
//
//        Provider producer = Fluentness.getFlow().instantiateProducer(
//            producerMock.getClass(),
//            producerMock.getClass().getCanonicalName()
//        );
//        Assert.assertNotNull(producer);
//    }
//
//    @Test(expected = ClassCastException.class)
//    public void instantiateProducer_wrongProducerClassIsGiven_classCastExceptionIsThrown()
//        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        ControllerProvider controllerProducerMock = mock(ControllerProvider.class);
//
//        Fluentness.getFlow().instantiateProducer(
//            RepositoryProducer.class,
//            controllerProducerMock.getClass().getCanonicalName()
//        );
//    }

}
