package org.fluentness.flow.locale;

import org.junit.Assert;
import org.junit.Test;

public class LocaleTest {

    @Test
    public void whenNoTranslationIsSet_thenNoTranslationIsGotButTheKeySelf() {
        Locale locale = new Locale();

        Assert.assertEquals(locale.get("test_message"), "test_message");
        Assert.assertEquals(locale.get("test_message2"), "test_message2");
        Assert.assertEquals(locale.get("test_message3"), "test_message3");
    }

    @Test
    public void whenTranslationsAreSet_thenTranslationsAreGot() {
        Locale locale = new Locale(
            test_message -> "Test Message",
            test_message2 -> "Test Message 2",
            test_message3 -> "Test Message 3"
        );

        Assert.assertEquals(locale.get("test_message"), "Test Message");
        Assert.assertEquals(locale.get("test_message2"), "Test Message 2");
        Assert.assertEquals(locale.get("test_message3"), "Test Message 3");
        Assert.assertEquals(locale.get("this_message_was_not_set"), "this_message_was_not_set");
    }

}
