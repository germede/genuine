package org.fluentness.base.config;

import org.fluentness.Fluentness;
import org.junit.*;

public class DefaultConfigTest {

    @Before
    public void setUp() {
        Config config = new DefaultConfig();
        config.initialize();
        Fluentness.base.setConfig(config);
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

}
