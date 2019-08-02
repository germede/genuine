package org.fluentness.base.service.localization;

import org.junit.Assert;
import org.junit.Test;

public class LocaleProviderTest {

    @Test
    public void getProvidedComponentType_always_LocaleIsReturned() {
        Localization localeProducer = new Localization() {
        };

        Assert.assertEquals(Localization.class, localeProducer.getComponentClass());
    }

    @Test
    public void translations_translationsAreGiven_newLocaleIsReturned() {
        Localization localeProducer = new Localization() {
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
