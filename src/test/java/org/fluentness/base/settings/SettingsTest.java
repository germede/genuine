package org.fluentness.base.settings;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SettingsTest {

    @Before
    public void before() {
        Settings.instance.initialize();
    }

    @Test
    public void whenNoSettingsAreSetThenDefaultSettingsAreGot() {
        Assert.assertEquals(Settings.instance.get(StringKey.APP_PROTOCOL), "http");
        Assert.assertNull(Settings.instance.get(StringKey.APP_KEYSTORE));
    }

    @Test
    public void whenSettingsAreSetThenThoseSettingsAreGot() {
        Settings.instance.set(StringKey.APP_PROTOCOL, "Lorem ipsum");
        Settings.instance.set(IntegerKey.APP_PORT, 1234);
        Settings.instance.set(BooleanKey.ENABLE_CACHE, true);

        Assert.assertEquals(Settings.instance.get(StringKey.APP_PROTOCOL), "Lorem ipsum");
        Assert.assertEquals((int) Settings.instance.get(IntegerKey.APP_PORT), 1234);
        Assert.assertEquals(Settings.instance.get(BooleanKey.ENABLE_CACHE), true);
    }

    @After
    public void after() {
        Settings.instance.clear();
    }

}
