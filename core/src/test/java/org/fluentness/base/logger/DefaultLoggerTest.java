package org.fluentness.base.logger;

import org.fluentness.Fluentness;
import org.fluentness.base.config.DefaultConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;

import static org.fluentness.base.config.BooleanKey.ENABLE_LOG_TO_CONSOLE;
import static org.fluentness.base.config.BooleanKey.ENABLE_LOG_TO_FILE;
import static org.fluentness.base.config.StringKey.LOG_LEVEL;
import static org.mockito.Mockito.*;

public class DefaultLoggerTest {

    private DefaultConfig config;
    private java.util.logging.Logger internalLogger;
    private Logger logger;

    @Before
    public void before() {
        config = new DefaultConfig();
        config.initialize();
        Fluentness.base.setConfig(config);

        // always a brand new internal logger
        internalLogger = spy(java.util.logging.Logger.getLogger(String.valueOf(System.currentTimeMillis())));
        logger = new DefaultLogger(internalLogger);
        Fluentness.base.setLogger(logger);
    }

    @Test
    public void whenNoConfigIsSet_thenLogLevelIsAllAndOnlyConsoleFormatterIsEnabled() {
        logger.initialize();

        Assert.assertEquals(internalLogger.getLevel().toString(), "ALL");
        Assert.assertEquals(internalLogger.getHandlers().length, 1);
        Assert.assertTrue(internalLogger.getHandlers()[0] instanceof ConsoleHandler);
        Assert.assertTrue(internalLogger.getHandlers()[0].getFormatter() instanceof ConsoleFormatter);
        Assert.assertEquals(internalLogger.getHandlers()[0].getLevel().toString(), "ALL");
    }

    @Test
    public void whenLogLevelIsOffAndLogToConsoleIsDisabled_thenLogLevelIsOffAndNoHandlerIsEnabled() {
        config.set(LOG_LEVEL, "OFF");
        config.set(ENABLE_LOG_TO_CONSOLE, false);
        logger.initialize();

        Assert.assertEquals(internalLogger.getLevel().toString(), "OFF");
        Assert.assertEquals(internalLogger.getHandlers().length, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIllegalLogLevelIsSet_thenIllegalArgumentExceptionIsThrown() {
        config.set(LOG_LEVEL, "Ich bin ein Berliner");
        logger.initialize();
    }

    @Test
    public void whenWarningLevelAndEnableLogToFileConfigAreSet_thenLevelIsWarningAndBothFormatterAreEnabled() {
        config.set(LOG_LEVEL, "WARNING");
        config.set(ENABLE_LOG_TO_FILE, true);
        logger.initialize();

        Assert.assertEquals(internalLogger.getLevel().toString(), "WARNING");
        Assert.assertEquals(internalLogger.getHandlers().length, 2);
        Assert.assertTrue(internalLogger.getHandlers()[0] instanceof ConsoleHandler);
        Assert.assertTrue(internalLogger.getHandlers()[0].getFormatter() instanceof ConsoleFormatter);
        Assert.assertEquals(internalLogger.getHandlers()[0].getLevel().toString(), "WARNING");
        Assert.assertTrue(internalLogger.getHandlers()[1] instanceof FileHandler);
        Assert.assertTrue(internalLogger.getHandlers()[1].getFormatter() instanceof FileFormatter);
        Assert.assertEquals(internalLogger.getHandlers()[1].getLevel().toString(), "WARNING");
    }

    @Test
    public void whenLoggerMethodsAreCalled_thenInternalLoggerMethodsAreCalled() {
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
