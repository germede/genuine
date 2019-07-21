package org.fluentness.base.logger;

import org.fluentness.Fluentness;
import org.fluentness.base.config.Config;
import org.fluentness.base.config.DefaultConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;

import static org.fluentness.base.config.BooleanKey.ENABLE_LOG_TO_CONSOLE;
import static org.fluentness.base.config.BooleanKey.ENABLE_LOG_TO_FILE;
import static org.fluentness.base.config.StringKey.LOG_LEVEL;
import static org.mockito.Mockito.*;

public class DefaultLoggerTest {

    private java.util.logging.Logger internalLogger;

    @Before
    public void setUp() {
        Config config = new DefaultConfig();
        config.setDefaultSettings();
        Fluentness.base.setConfig(config);

        // always a brand new internal logger
        internalLogger = spy(java.util.logging.Logger.getLogger(String.valueOf(System.currentTimeMillis())));
        Fluentness.base.setLogger(new DefaultLogger(internalLogger));
    }

    @Test
    public void initialize_noConfigIsSet_logLevelIsAllAndOnlyConsoleFormatterIsEnabled() throws IOException {
        Fluentness.base.getLogger().initialize();

        Assert.assertEquals("ALL", internalLogger.getLevel().toString());
        Assert.assertEquals(1, internalLogger.getHandlers().length);
        Assert.assertTrue(internalLogger.getHandlers()[0] instanceof ConsoleHandler);
        Assert.assertTrue(internalLogger.getHandlers()[0].getFormatter() instanceof ConsoleFormatter);
        Assert.assertEquals("ALL", internalLogger.getHandlers()[0].getLevel().toString());
    }

    @Test
    public void initialize_logLevelIsOffAndLogToConsoleIsDisabled_logLevelIsOffAndNoHandlerIsEnabled()
        throws IOException {

        Fluentness.base.getConfig().set(LOG_LEVEL, "OFF");
        Fluentness.base.getConfig().set(ENABLE_LOG_TO_CONSOLE, false);
        Fluentness.base.getLogger().initialize();

        Assert.assertEquals("OFF", internalLogger.getLevel().toString());
        Assert.assertEquals(0, internalLogger.getHandlers().length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void initialize_illegalLogLevelIsSet_illegalArgumentExceptionIsThrown() throws IOException {
        Fluentness.base.getConfig().set(LOG_LEVEL, "THIS LEVEL DOES NOT EVEN EXIST");
        Fluentness.base.getLogger().initialize();
    }

    @Test
    public void initialize_warningLevelAndEnableLogToFileConfigAreSet_levelIsWarningAndBothFormatterAreEnabled()
        throws IOException {

        Fluentness.base.getConfig().set(LOG_LEVEL, "WARNING");
        Fluentness.base.getConfig().set(ENABLE_LOG_TO_FILE, true);
        Fluentness.base.getLogger().initialize();

        Assert.assertEquals("WARNING", internalLogger.getLevel().toString());
        Assert.assertEquals(2, internalLogger.getHandlers().length);
        Assert.assertTrue(internalLogger.getHandlers()[0] instanceof ConsoleHandler);
        Assert.assertTrue(internalLogger.getHandlers()[0].getFormatter() instanceof ConsoleFormatter);
        Assert.assertEquals("WARNING", internalLogger.getHandlers()[0].getLevel().toString());
        Assert.assertTrue(internalLogger.getHandlers()[1] instanceof FileHandler);
        Assert.assertTrue(internalLogger.getHandlers()[1].getFormatter() instanceof FileFormatter);
        Assert.assertEquals("WARNING", internalLogger.getHandlers()[1].getLevel().toString());
    }

    @Test
    public void loggerMethods_loggerMethodsAreCalled_internalLoggerMethodsAreCalled() {
        Fluentness.base.getLogger().fine("Everything is fine");
        Fluentness.base.getLogger().fine("Everything is fine again");
        Fluentness.base.getLogger().info("Just for info %s", 1234);
        Fluentness.base.getLogger().warning("Attention, this is a first warning");
        Fluentness.base.getLogger().warning("Attention, this is a second warning");
        Fluentness.base.getLogger().warning("Attention, this is a third warning");
        Fluentness.base.getLogger().severe("This is very serious");
        Fluentness.base.getLogger().severe(new Exception("An exception occurred"));

        verify(internalLogger, times(2)).fine(anyString());
        verify(internalLogger, times(1)).info(anyString());
        verify(internalLogger, times(3)).warning(anyString());
        verify(internalLogger, times(2)).severe(anyString());
    }

}
