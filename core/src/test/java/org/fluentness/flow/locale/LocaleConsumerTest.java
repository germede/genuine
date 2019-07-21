package org.fluentness.flow.locale;

import org.fluentness.Fluentness;
import org.fluentness.base.exceptions.OnionLayerComplianceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LocaleConsumerTest {

    @Before
    public void setUp() {
        Fluentness.flow.reset();
    }

    @Test
    public void locales_flowLocaleProviderIsSet_flowLocaleProviderIsGot() throws OnionLayerComplianceException {
        LocaleConsumer localeConsumer = new LocaleConsumer() {
        };
        Fluentness.flow.setProvider(LocaleProvider.class, new LocaleProvider() {
        });

        Assert.assertEquals(Fluentness.flow.getProvider(LocaleProvider.class), localeConsumer.locales());
    }

    @Test
    public void locales_noFlowLocaleProviderIsSet_nullIsGot() {
        LocaleConsumer localeConsumer = new LocaleConsumer() {
        };

        Assert.assertNull(localeConsumer.locales());
    }

}
