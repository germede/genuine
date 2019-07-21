package org.fluentness.flow.locale;

import org.junit.Assert;
import org.junit.Test;

public class LocaleProviderTest {

    @Test
    public void getProvidedComponentType_always_LocaleIsReturned() {
        LocaleProvider localeProvider = new LocaleProvider() {
        };

        Assert.assertEquals(Locale.class, localeProvider.getProvidedComponentType());
    }

    @Test
    public void translations_translationsAreGiven_newLocaleIsReturned() {
        LocaleProvider localeProvider = new LocaleProvider() {
        };

        Locale expectedLocale = new Locale(
            test_message -> "Test Message",
            test_message2 -> "Test Message 2",
            test_message3 -> "Test Message 3"
        );
        Locale actualLocale = localeProvider.translations(
            test_message -> "Test Message",
            test_message2 -> "Test Message 2",
            test_message3 -> "Test Message 3"
        );

        Assert.assertNotNull(actualLocale);
        Assert.assertEquals(expectedLocale.getAll(), actualLocale.getAll());
    }
}
