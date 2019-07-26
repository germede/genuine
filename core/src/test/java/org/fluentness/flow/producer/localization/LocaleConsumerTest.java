package org.fluentness.flow.producer.localization;

import org.fluentness.Fluentness;
import org.fluentness.flow.consumer.LocalizationConsumer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LocaleConsumerTest {

    @Before
    public void setUp() {
        Fluentness.getFlow().reset();
    }

    @Test
    public void locales_flowLocaleProducerIsSet_flowLocaleProducerIsGot() throws OnionLayerComplianceException {
        LocalizationConsumer localeConsumer = new LocalizationConsumer() {
        };
        Fluentness.getFlow().setProducer(LocalizationProducer.class, new LocalizationProducer() {
        });

        Assert.assertEquals(Fluentness.getFlow().getProducer(LocalizationProducer.class), localeConsumer.locales());
    }

    @Test
    public void locales_noFlowLocaleProducerIsSet_nullIsGot() {
        LocalizationConsumer localeConsumer = new LocalizationConsumer() {
        };

        Assert.assertNull(localeConsumer.locales());
    }

}
