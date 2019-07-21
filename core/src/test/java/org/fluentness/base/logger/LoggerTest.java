package org.fluentness.base.logger;

import org.fluentness.Fluentness;
import org.fluentness.base.config.Config;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoggerTest {

    private Config configMock = mock(Config.class);

    @Before
    public void before() {
        configMock.clear();
        Fluentness.base.setConfig(configMock);
        Fluentness.base.getLogger().initialize();
    }

    @Test
    public void whenNoConfigIsSet_thenLogLevelIsAllAndOnlyConsoleLoggerIsEnabled() {

        Assert.assertEquals(Fluentness.base.getLogger().getInternalLogger().getLevel().toString(), "ALL");
        Assert.assertEquals(Fluentness.base.getLogger().);
        Fluentness.base.getLogger().initialize();
    }

    @Test
    public void when () {

        Assert.assertEquals(Fluentness.base.getLogger().getInternalLogger().getLevel().toString(), "ALL");
    }


    @Test
    public void whenLoggerMethodsAreCalled_thenInternalLoggerMethodsAreCalled() {

        java.util.logging.Logger internalLoggerMock = mock(java.util.logging.Logger.class);
        Fluentness.base.getLogger().setInternalLogger(internalLoggerMock);

        Fluentness.base.getLogger().fine("Everything is fine");
        Fluentness.base.getLogger().info("Just for info %s", 1234);
        Fluentness.base.getLogger().warning("Attention, this is a warning");
        Fluentness.base.getLogger().severe("This is very serious");
        Fluentness.base.getLogger().severe(new Exception("An exception occurred"));

        verify(internalLoggerMock, times(1)).fine(anyString());
        verify(internalLoggerMock, times(1)).info(anyString());
        verify(internalLoggerMock, times(1)).warning(anyString());
        verify(internalLoggerMock, times(2)).severe(anyString());
    }

}
