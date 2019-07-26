package org.fluentness.flow.component.localization;

import org.fluentness.flow.provider.LocalizationProvider;
import org.junit.Assert;
import org.junit.Test;

public class LocaleProducerTest {

    @Test
    public void getProvidedComponentType_always_LocaleIsReturned() {
        LocalizationProvider localeProducer = new LocalizationProvider() {
        };

        Assert.assertEquals(Localization.class, localeProducer.getProducedComponentType());
    }

    @Test
    public void translations_translationsAreGiven_newLocaleIsReturned() {
        LocalizationProvider localeProducer = new LocalizationProvider() {
        };

        Localization expectedLocale = new Localization(
            test_message -> "Test Message",
            test_message2 -> "Test Message 2",
            test_message3 -> "Test Message 3"
        );
        Localization actualLocale = localeProducer.translations(
            test_message -> "Test Message",
            test_message2 -> "Test Message 2",
            test_message3 -> "Test Message 3"
        );

        Assert.assertNotNull(actualLocale);
        Assert.assertEquals(expectedLocale.getAll(), actualLocale.getAll());
    }
}
