package org.fluentness.service.server;

import org.fluentness.It;
import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.injector.Injector;
import org.fluentness.service.logger.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SunServerPerformanceTest {

    private Injector injector;
    private Configurator configurator;
    private Logger logger;

    private Server server;

    @Before
    public void setUp() {
        injector = Mockito.mock(Injector.class);
        configurator = Mockito.mock(Configurator.class);
        logger = Mockito.mock(Logger.class);
    }

    @Test(timeout = 3000)
    public void start_noConfigurationIsSet_serverCanBeStartedAndStopped() throws IOException {
        Mockito.when(configurator.get(Server.PORT)).thenReturn(-10);
        Mockito.when(configurator.get(Server.CONTEXT)).thenReturn("/");
        Mockito.when(configurator.get(Server.RESPONSE_ENCODING)).thenReturn("UTF-8");
        Mockito.when(configurator.get(Server.SINGLE_PAGE_MODE)).thenReturn(true);
        server = new SunServer(injector, configurator, logger);
        server.start();

        It.should.equals(3,3);
        It.must.equals(3,3);
        It.may.equals(3,3);
        It.may.equals(3,"3");

        //Mockito.verify(logger, Mockito.times(1)).info(Mockito.any(), Mockito.any(), Mockito.any());
        server.stop();
    }

    @Test(timeout = 3000)
    public void start_rootPathIsRequestedToLocalhost8000_statusCode200IsResponded() throws IOException {
        server = new SunServer(injector, configurator, logger);
        server.start();
        HttpURLConnection connection = (HttpURLConnection) new URL("http://127.0.0.1:8000").openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        Assert.assertEquals(200, connection.getResponseCode());
        server.stop();
    }

    @Test(timeout = 3000, expected = NumberFormatException.class)
    public void start_invalidPortIsSet_lifecycleExceptionIsThrown() throws IOException {
        Mockito.when(configurator.get(Server.PORT)).thenReturn(-10);

        server = new SunServer(injector, configurator, logger);
        server.start();
        server.stop();
    }

    @Test(timeout = 3000)
    public void stop_serverWasNotStarted_infoIsLogged() throws IOException {
        server = new SunServer(injector, configurator, logger);
        server.stop();

        Mockito.verify(logger, Mockito.times(1)).info(Mockito.any());
    }

}
