package org.fluentness.service.server;

import org.fluentness.service.configurator.Configurator;
import org.fluentness.service.logger.Logger;
import org.fluentness.service.router.Router;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.fluentness.service.configurator.Configurator.server_port;

public class TomcatServerTest {

    private Configurator configurator;
    private Logger logger;
    private Router router;

    private Server server;

    @Before
    public void setUp() {
        configurator = Mockito.mock(Configurator.class);
        logger = Mockito.mock(Logger.class);
        router = Mockito.mock(Router.class);
    }

    @Test(timeout = 3000)
    public void start_noConfigurationIsSet_serverCanBeStartedAndStopped() throws Exception {
        server = new TomcatServer(configurator, logger, router);
        server.start();

        Mockito.verify(logger, Mockito.times(1)).info(Mockito.any(), Mockito.any(), Mockito.any());
        server.stop();
    }

    @Test(timeout = 3000)
    public void start_rootPathIsRequestedToLocalhost8000_statusCode200IsResponded() throws Exception {
        server = new TomcatServer(configurator, logger, router);
        server.start();
        HttpURLConnection connection = (HttpURLConnection) new URL("http://127.0.0.1:8000").openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        Assert.assertEquals(200, connection.getResponseCode());
        server.stop();
    }

    @Test(timeout = 3000, expected = NumberFormatException.class)
    public void start_invalidPortIsSet_lifecycleExceptionIsThrown() throws Exception {
        Mockito.when(configurator.has(server_port)).thenReturn(true);
        Mockito.when(configurator.get(server_port)).thenReturn(-10);

        server = new TomcatServer(configurator, logger, router);
        server.start();
        server.stop();
    }

    @Test(timeout = 3000)
    public void stop_serverWasNotStarted_infoIsLogged() {
        server = new TomcatServer(configurator, logger, router);
        server.stop();

        Mockito.verify(logger, Mockito.times(1)).info(Mockito.any());
    }

}
