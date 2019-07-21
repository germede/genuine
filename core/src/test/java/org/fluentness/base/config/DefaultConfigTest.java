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
    public void has_noSettingsAreSet_onlyDefaultSettingsAreThere() {
        Assert.assertTrue(Fluentness.base.getConfig().has(StringKey.APP_PROTOCOL));
        Assert.assertFalse(Fluentness.base.getConfig().has(StringKey.APP_KEYSTORE));
    }

    @Test
    public void has_someSettingsAreSet_thoseSettingsAreThere() {
        Fluentness.base.getConfig().set(StringKey.APP_PROTOCOL, "Lorem ipsum");
        Fluentness.base.getConfig().set(IntegerKey.APP_PORT, 1234);
        Fluentness.base.getConfig().set(BooleanKey.ENABLE_CACHE, true);

        Assert.assertTrue(Fluentness.base.getConfig().has(StringKey.APP_PROTOCOL));
        Assert.assertTrue(Fluentness.base.getConfig().has(IntegerKey.APP_PORT));
        Assert.assertTrue(Fluentness.base.getConfig().has(BooleanKey.ENABLE_CACHE));
    }

    @Test
    public void get_NoSettingsAreSet_thenDefaultSettingsAreGot() {
        Assert.assertEquals("http", Fluentness.base.getConfig().get(StringKey.APP_PROTOCOL));
        Assert.assertNull(Fluentness.base.getConfig().get(StringKey.APP_KEYSTORE));
    }

    @Test
    public void get_SettingsAreSet_thenThoseSettingsAreGot() {
        Fluentness.base.getConfig().set(StringKey.APP_PROTOCOL, "Lorem ipsum");
        Fluentness.base.getConfig().set(IntegerKey.APP_PORT, 1234);
        Fluentness.base.getConfig().set(BooleanKey.ENABLE_CACHE, true);

        Assert.assertEquals("Lorem ipsum", Fluentness.base.getConfig().get(StringKey.APP_PROTOCOL));
        Assert.assertEquals(1234, (int) Fluentness.base.getConfig().get(IntegerKey.APP_PORT));
        Assert.assertEquals(true, Fluentness.base.getConfig().get(BooleanKey.ENABLE_CACHE));
    }

}
