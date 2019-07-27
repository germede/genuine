package org.fluentness.base.service.logger;

public class DefaultLoggerTest {
//
//    private java.util.logging.Logger internalLogger;
//
//    @Before
//    public void setUp() {
//        ConfigService config = new DefaultConfigService();
//        config.setDefaultSettings();
//        Fluentness.getBase().setConfig(config);
//
//        // always a brand new internal logger
//        internalLogger = spy(java.util.logging.Logger.getLogger(String.valueOf(System.currentTimeMillis())));
//        Fluentness.getBase().setLogger(new DefaultLoggerService(internalLogger));
//    }
//
//    @Test
//    public void initialize_noConfigIsSet_logLevelIsAllAndOnlyConsoleFormatterIsEnabled() throws IOException {
//        Fluentness.getBase().getLogger().initialize();
//
//        Assert.assertEquals("ALL", internalLogger.getLevel().toString());
//        Assert.assertEquals(1, internalLogger.getHandlers().length);
//        Assert.assertTrue(internalLogger.getHandlers()[0] instanceof ConsoleHandler);
//        Assert.assertTrue(internalLogger.getHandlers()[0].getFormatter() instanceof ConsoleFormatter);
//        Assert.assertEquals("ALL", internalLogger.getHandlers()[0].getLevel().toString());
//    }
//
//    @Test
//    public void initialize_logLevelIsOffAndLogToConsoleIsDisabled_logLevelIsOffAndNoHandlerIsEnabled()
//        throws IOException {
//
//        Fluentness.getBase().getConfig().set(LOG_LEVEL, "OFF");
//        Fluentness.getBase().getConfig().set(ENABLE_LOG_TO_CONSOLE, false);
//        Fluentness.getBase().getLogger().initialize();
//
//        Assert.assertEquals("OFF", internalLogger.getLevel().toString());
//        Assert.assertEquals(0, internalLogger.getHandlers().length);
//    }
//
//    @Test(expected = IllegalArgumentException.class)
//    public void initialize_illegalLogLevelIsSet_illegalArgumentExceptionIsThrown() throws IOException {
//        Fluentness.getBase().getConfig().set(LOG_LEVEL, "THIS LEVEL DOES NOT EVEN EXIST");
//        Fluentness.getBase().getLogger().initialize();
//    }
//
//    @Test
//    public void initialize_warningLevelAndEnableLogToFileConfigAreSet_levelIsWarningAndBothFormatterAreEnabled()
//        throws IOException {
//
//        Fluentness.getBase().getConfig().set(LOG_LEVEL, "WARNING");
//        Fluentness.getBase().getConfig().set(ENABLE_LOG_TO_FILE, true);
//        Fluentness.getBase().getLogger().initialize();
//
//        Assert.assertEquals("WARNING", internalLogger.getLevel().toString());
//        Assert.assertEquals(2, internalLogger.getHandlers().length);
//        Assert.assertTrue(internalLogger.getHandlers()[0] instanceof ConsoleHandler);
//        Assert.assertTrue(internalLogger.getHandlers()[0].getFormatter() instanceof ConsoleFormatter);
//        Assert.assertEquals("WARNING", internalLogger.getHandlers()[0].getLevel().toString());
//        Assert.assertTrue(internalLogger.getHandlers()[1] instanceof FileHandler);
//        Assert.assertTrue(internalLogger.getHandlers()[1].getFormatter() instanceof FileFormatter);
//        Assert.assertEquals("WARNING", internalLogger.getHandlers()[1].getLevel().toString());
//    }
//
//    @Test
//    public void loggerMethods_loggerMethodsAreCalled_internalLoggerMethodsAreCalled() {
//        Fluentness.getBase().getLogger().fine("Everything is fine");
//        Fluentness.getBase().getLogger().fine("Everything is fine again");
//        Fluentness.getBase().getLogger().info("Just for info %s", 1234);
//        Fluentness.getBase().getLogger().warning("Attention, this is a first warning");
//        Fluentness.getBase().getLogger().warning("Attention, this is a second warning");
//        Fluentness.getBase().getLogger().warning("Attention, this is a third warning");
//        Fluentness.getBase().getLogger().severe("This is very serious");
//        Fluentness.getBase().getLogger().severe(new Exception("An exception occurred"));
//
//        verify(internalLogger, times(2)).fine(anyString());
//        verify(internalLogger, times(1)).info(anyString());
//        verify(internalLogger, times(3)).warning(anyString());
//        verify(internalLogger, times(2)).severe(anyString());
//    }

}
