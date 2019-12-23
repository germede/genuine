package org.fluentness.server;

import org.fluentness.It;
import org.fluentness.configuration.Configuration;
import org.fluentness.controller.TestWebController;
import org.fluentness.injector.Injector;
import org.fluentness.logger.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SunServerTest {

    private static TestWebController controller = new TestWebController();

    private Injector injector;
    private Configuration configuration;
    private Logger logger;
    private Server server;

    @Before
    public void setUp() throws IOException, NoSuchMethodException {
        injector = Mockito.mock(Injector.class);
        Mockito.when(injector.getInstance(TestWebController.class)).thenReturn(controller);

        configuration = Mockito.mock(Configuration.class);
        Mockito.when(configuration.get(Server.PORT)).thenReturn(8000);
        Mockito.when(configuration.get(Server.CONTEXT)).thenReturn("/");
        Mockito.when(configuration.get(Server.RESPONSE_ENCODING)).thenReturn("UTF-8");
        Mockito.when(configuration.get(Server.SINGLE_PAGE_MODE)).thenReturn(true);

        logger = Mockito.mock(Logger.class);

        server = new SunServer(injector, configuration, logger);
        server.start();
    }

    public String dummyAction() {
        return "asdf";
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test(timeout = 3000)
    public void canBeStarted() {
        Mockito.verify(logger, Mockito.times(1)).info(Mockito.any(), Mockito.any(), Mockito.any());
    }

    @Test(timeout = 3000)
    public void respondsWith200() throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("http://127.0.0.1:8000").openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        It.must.equals(connection.getResponseCode(),200);
    }

}
