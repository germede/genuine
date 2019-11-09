package org.fluentness.service.serving;

import org.fluentness.service.configuration.ConfigurationService;
import org.fluentness.service.logging.LoggingService;
import org.fluentness.service.routing.RoutingService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.fluentness.service.configuration.ConfigurationService.server_port;

public class TomcatServerTest {

    private ConfigurationService configuration;
    private LoggingService logger;
    private RoutingService router;

    private ServingService server;

    @Before
    public void setUp() {
        configuration = Mockito.mock(ConfigurationService.class);
        logger = Mockito.mock(LoggingService.class);
        router = Mockito.mock(RoutingService.class);
    }

    @Test(timeout = 3000)
    public void start_noConfigurationIsSet_serverCanBeStartedAndStopped() throws Exception {
        server = new TomcatServingService(configuration, logger, router);
        server.start();

        Mockito.verify(logger, Mockito.times(1)).info(Mockito.any(), Mockito.any(), Mockito.any());
        server.stop();
    }

    @Test(timeout = 3000)
    public void start_rootPathIsRequestedToLocalhost8000_statusCode200IsResponded() throws Exception {
        server = new TomcatServingService(configuration, logger, router);
        server.start();
        HttpURLConnection connection = (HttpURLConnection) new URL("http://127.0.0.1:8000").openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        Assert.assertEquals(200, connection.getResponseCode());
        server.stop();
    }

    @Test(timeout = 3000, expected = NumberFormatException.class)
    public void start_invalidPortIsSet_lifecycleExceptionIsThrown() throws Exception {
        Mockito.when(configuration.has(server_port)).thenReturn(true);
        Mockito.when(configuration.get(server_port)).thenReturn(-10);

        server = new TomcatServingService(configuration, logger, router);
        server.start();
        server.stop();
    }

    @Test(timeout = 3000)
    public void stop_serverWasNotStarted_infoIsLogged() {
        server = new TomcatServingService(configuration, logger, router);
        server.stop();

        Mockito.verify(logger, Mockito.times(1)).info(Mockito.any());
    }

}
