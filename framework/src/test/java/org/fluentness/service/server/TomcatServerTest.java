package org.fluentness.service.server;

import org.fluentness.service.configuration.ConfigurationService;
import org.fluentness.service.logger.LoggerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.net.HttpURLConnection;
import java.net.URL;

public class TomcatServerTest {

    private ConfigurationService configuration;
    private LoggerService logger;
    private DispatcherServlet dispatcherServlet;

    private ServerService server;

    @Before
    public void setUp() {
        configuration = Mockito.mock(ConfigurationService.class);
        logger = Mockito.mock(LoggerService.class);
        dispatcherServlet = Mockito.mock(DispatcherServlet.class);
    }

    @Test(timeout = 3000)
    public void start_noConfigurationIsSet_serverCanBeStartedAndStopped() throws Exception {
        server = new TomcatServerService(configuration, logger, dispatcherServlet);
        server.start();

        Mockito.verify(logger, Mockito.times(1)).info(Mockito.any(), Mockito.any(), Mockito.any());
        server.stop();
    }

    @Test(timeout = 3000)
    public void start_rootPathIsRequestedToLocalhost8000_statusCode200IsResponded() throws Exception {
        server = new TomcatServerService(configuration, logger, dispatcherServlet);
        server.start();
        HttpURLConnection connection = (HttpURLConnection) new URL("http://127.0.0.1:8000").openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        Assert.assertEquals(200, connection.getResponseCode());
        server.stop();
    }

    @Test(timeout = 3000, expected = NumberFormatException.class)
    public void start_invalidPortIsSet_lifecycleExceptionIsThrown() throws Exception {
        Mockito.when(configuration.has("server_port")).thenReturn(true);
        Mockito.when(configuration.get("server_port")).thenReturn("notAnInteger");

        server = new TomcatServerService(configuration, logger, dispatcherServlet);
        server.start();
        server.stop();
    }

    @Test(timeout = 3000)
    public void stop_serverWasNotStarted_infoIsLogged() {
        server = new TomcatServerService(configuration, logger, dispatcherServlet);
        server.stop();

        Mockito.verify(logger, Mockito.times(1)).info(Mockito.any());
    }

}
