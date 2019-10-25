package org.fluentness.service;

public class BaseTest {
//
//    @Before
//    public void setUp() {
//        Fluentness.getBase().reset();
//    }
//
//    @Test
//    public void getters_noneIsDone_nullIsGot() {
//        Assert.assertNull(Fluentness.getBase().getConfig());
//        Assert.assertNull(Fluentness.getBase().getLogger());
//        Assert.assertNull(Fluentness.getBase().getServer());
//        Assert.assertNull(Fluentness.getBase().getCacher());
//    }
//
//    @Test
//    public void getters_baseIsInitialized_defaultImplementationsAreGot() throws IOException {
//        Fluentness.getBase().initialize();
//
//        Assert.assertTrue(Fluentness.getBase().getConfig() instanceof DefaultConfigService);
//        Assert.assertTrue(Fluentness.getBase().getLogger() instanceof DefaultLoggerService);
//        Assert.assertTrue(Fluentness.getBase().getServer() instanceof DefaultServerService);
//        Assert.assertTrue(Fluentness.getBase().getCacher() instanceof DefaultViewCacheService);
//    }
//
//    @Test
//    public void getters_customBaseComponentsAreSet_customBaseComponentsAreGot() throws IOException {
//        ConfigService configMock = mock(DefaultConfigService.class);
//        LoggerService loggerMock = mock(LoggerService.class);
//        ServerService serverMock = mock(ServerService.class);
//        ViewCacheService cacherMock = mock(ViewCacheService.class);
//        Fluentness.getBase().setConfig(configMock);
//        Fluentness.getBase().setLogger(loggerMock);
//        Fluentness.getBase().setServer(serverMock);
//        Fluentness.getBase().setCacher(cacherMock);
//        Fluentness.getBase().initialize();
//
//        Assert.assertNotNull(Fluentness.getBase().getConfig());
//        Assert.assertFalse(Fluentness.getBase().getConfig() instanceof DefaultConfigService);
//        Assert.assertNotNull(Fluentness.getBase().getLogger());
//        Assert.assertFalse(Fluentness.getBase().getLogger() instanceof DefaultLoggerService);
//        Assert.assertNotNull(Fluentness.getBase().getServer());
//        Assert.assertFalse(Fluentness.getBase().getServer() instanceof DefaultServerService);
//        Assert.assertNotNull(Fluentness.getBase().getCacher());
//        Assert.assertFalse(Fluentness.getBase().getCacher() instanceof DefaultViewCacheService);
//    }

}
