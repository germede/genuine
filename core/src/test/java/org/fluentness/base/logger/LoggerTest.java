package org.fluentness.base.logger;

import org.fluentness.Fluentness;
import org.fluentness.base.config.BooleanKey;
import org.fluentness.base.config.IntegerKey;
import org.fluentness.base.config.StringKey;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest {

    @Before
    public void before() {
        Fluentness.base.getConfig().initialize();
    }

    @Test
    public void whenNoSettingsAreSet_thenDefaultSettingsAreGot() {
        Assert.assertEquals(Fluentness.base.getConfig().get(StringKey.APP_PROTOCOL), "http");
        Assert.assertNull(Fluentness.base.getConfig().get(StringKey.APP_KEYSTORE));
    }

    @Test
    public void whenSettingsAreSet_thenThoseSettingsAreGot() {
        Fluentness.base.getConfig().set(StringKey.APP_PROTOCOL, "Lorem ipsum");
        Fluentness.base.getConfig().set(IntegerKey.APP_PORT, 1234);
        Fluentness.base.getConfig().set(BooleanKey.ENABLE_CACHE, true);

        Assert.assertEquals(Fluentness.base.getConfig().get(StringKey.APP_PROTOCOL), "Lorem ipsum");
        Assert.assertEquals((int) Fluentness.base.getConfig().get(IntegerKey.APP_PORT), 1234);
        Assert.assertEquals(Fluentness.base.getConfig().get(BooleanKey.ENABLE_CACHE), true);
    }

    @After
    public void after() {
        Fluentness.base.getConfig().clear();
    }

}
