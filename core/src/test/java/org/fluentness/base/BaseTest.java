package org.fluentness.base;

import org.fluentness.Fluentness;
import org.fluentness.AbstractUnitTest;
import org.fluentness.base.cacher.Cacher;
import org.fluentness.base.cacher.DefaultCacher;
import org.fluentness.base.config.Config;
import org.fluentness.base.config.DefaultConfig;
import org.fluentness.base.logger.DefaultLogger;
import org.fluentness.base.logger.Logger;
import org.fluentness.base.server.DefaultServer;
import org.fluentness.base.server.Server;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class BaseTest extends AbstractUnitTest {

    @Test
    public void whenNothingIsDone_thenBaseComponentsAreNotSet() {
        Assert.assertNull(Fluentness.base.getConfig());
        Assert.assertNull(Fluentness.base.getLogger());
        Assert.assertNull(Fluentness.base.getServer());
        Assert.assertNull(Fluentness.base.getCacher());
    }

    @Test
    public void whenBaseIsInitialized_thenBaseComponentsAreSetToTheirDefaultImplementations() throws IOException {
        Fluentness.base.initialize();

        Assert.assertTrue(Fluentness.base.getConfig() instanceof DefaultConfig);
        Assert.assertTrue(Fluentness.base.getLogger() instanceof DefaultLogger);
        Assert.assertTrue(Fluentness.base.getServer() instanceof DefaultServer);
        Assert.assertTrue(Fluentness.base.getCacher() instanceof DefaultCacher);
    }

    @Test
    public void whenCustomComponentsAreSetBeforehand_thenCustomBaseComponentsAreGotAfterInitializing() throws IOException {
        Config configMock = mock(Config.class);
        Logger loggerMock = mock(Logger.class);
        Server serverMock = mock(Server.class);
        Cacher cacherMock = mock(Cacher.class);
        Fluentness.base.setConfig(configMock);
        Fluentness.base.setLogger(loggerMock);
        Fluentness.base.setServer(serverMock);
        Fluentness.base.setCacher(cacherMock);
        Fluentness.base.initialize();

        Assert.assertNotNull(Fluentness.base.getConfig());
        Assert.assertFalse(Fluentness.base.getConfig() instanceof DefaultConfig);
        Assert.assertNotNull(Fluentness.base.getLogger());
        Assert.assertFalse(Fluentness.base.getLogger() instanceof DefaultLogger);
        Assert.assertNotNull(Fluentness.base.getServer());
        Assert.assertFalse(Fluentness.base.getServer() instanceof DefaultServer);
        Assert.assertNotNull(Fluentness.base.getCacher());
        Assert.assertFalse(Fluentness.base.getCacher() instanceof DefaultCacher);
    }

}
