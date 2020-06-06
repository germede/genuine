package org.fluentness.service.configuration;

import org.junit.Assert;
import org.junit.Test;

public class ConfigurationTest {

    private final Setting<String> stringSetting = new Setting<>("defaultValue");
    private final Setting<Integer> integerSetting = new Setting<>();
    private final Configuration configuration = new AbstractConfiguration() {
        @Override
        protected void configure() {
            set(stringSetting, "anotherValue");
            set(integerSetting, 1234);
        }
    };

    @Test
    public void newEmptyConfiguration_noExceptionIsThrown() {
        new ConfigurationImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNullSetting_IllegalArgumentExceptionIsThrown() {
        new AbstractConfiguration() {
            @Override
            protected void configure() {
                set(null, "test");
            }
        };
    }

    @Test
    public void hasNull_falseIsReturned() {
        Assert.assertFalse(configuration.has(null));
    }

    @Test
    public void hasUnsetSetting_falseIsReturned() {
        final Setting<String> stringSetting = new Setting<>("defaultValue");
        final Setting<Integer> integerSetting = new Setting<>();

        Assert.assertFalse(configuration.has(stringSetting));
        Assert.assertFalse(configuration.has(integerSetting));
    }

    @Test
    public void hasSetSetting_trueIsReturned() {
        Assert.assertTrue(configuration.has(stringSetting));
        Assert.assertTrue(configuration.has(integerSetting));
    }

    @Test
    public void getUnsetSettingWithDefaultValue_defaultValueIsReturned() {
        final Setting<String> stringSetting = new Setting<>("defaultValue");
        final Setting<Integer> integerSetting = new Setting<>(1234);

        Assert.assertEquals(configuration.get(stringSetting), "defaultValue");
        Assert.assertEquals((int) configuration.get(integerSetting), 1234);
    }

    @Test
    public void getUnsetSettingWithoutDefaultValue_nullIsReturned() {
        final Setting<String> stringSetting = new Setting<>();
        final Setting<Integer> integerSetting = new Setting<>();

        Assert.assertNull(configuration.get(stringSetting));
        Assert.assertNull(configuration.get(integerSetting));
    }

    @Test
    public void getSetSetting_setValueIsReturned() {
        Assert.assertEquals(configuration.get(stringSetting), "anotherValue");
        Assert.assertEquals((int) configuration.get(integerSetting), 1234);
    }

}