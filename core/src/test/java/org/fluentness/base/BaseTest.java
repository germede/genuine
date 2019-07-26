package org.fluentness.base;

import org.fluentness.Fluentness;
import org.fluentness.base.service.cacher.Cacher;
import org.fluentness.base.service.cacher.DefaultCacher;
import org.fluentness.base.common.environment.Config;
import org.fluentness.base.common.environment.DefaultConfig;
import org.fluentness.base.service.logger.DefaultLogger;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.base.service.server.DefaultServer;
import org.fluentness.base.service.server.Server;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.mock;

public class BaseTest {

    @Before
    public void setUp() {
        Fluentness.getBase().reset();
    }

    @Test
    public void getters_noneIsDone_nullIsGot() {
        Assert.assertNull(Fluentness.getBase().getConfig());
        Assert.assertNull(Fluentness.getBase().getLogger());
        Assert.assertNull(Fluentness.getBase().getServer());
        Assert.assertNull(Fluentness.getBase().getCacher());
    }

    @Test
    public void getters_baseIsInitialized_defaultImplementationsAreGot() throws IOException {
        Fluentness.getBase().initialize();

        Assert.assertTrue(Fluentness.getBase().getConfig() instanceof DefaultConfig);
        Assert.assertTrue(Fluentness.getBase().getLogger() instanceof DefaultLogger);
        Assert.assertTrue(Fluentness.getBase().getServer() instanceof DefaultServer);
        Assert.assertTrue(Fluentness.getBase().getCacher() instanceof DefaultCacher);
    }

    @Test
    public void getters_customBaseComponentsAreSet_customBaseComponentsAreGot() throws IOException {
        Config configMock = mock(Config.class);
        Logger loggerMock = mock(Logger.class);
        Server serverMock = mock(Server.class);
        Cacher cacherMock = mock(Cacher.class);
        Fluentness.getBase().setConfig(configMock);
        Fluentness.getBase().setLogger(loggerMock);
        Fluentness.getBase().setServer(serverMock);
        Fluentness.getBase().setCacher(cacherMock);
        Fluentness.getBase().initialize();

        Assert.assertNotNull(Fluentness.getBase().getConfig());
        Assert.assertFalse(Fluentness.getBase().getConfig() instanceof DefaultConfig);
        Assert.assertNotNull(Fluentness.getBase().getLogger());
        Assert.assertFalse(Fluentness.getBase().getLogger() instanceof DefaultLogger);
        Assert.assertNotNull(Fluentness.getBase().getServer());
        Assert.assertFalse(Fluentness.getBase().getServer() instanceof DefaultServer);
        Assert.assertNotNull(Fluentness.getBase().getCacher());
        Assert.assertFalse(Fluentness.getBase().getCacher() instanceof DefaultCacher);
    }

}
