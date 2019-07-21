package org.fluentness.flow.locale;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class LocaleTest {

    @Test
    public void get_noTranslationIsSet_translationKeyIsGot() {
        Locale locale = new Locale();

        Assert.assertEquals("test_message", locale.get("test_message"));
        Assert.assertEquals("test_message2", locale.get("test_message2"));
        Assert.assertEquals("test_message3", locale.get("test_message3"));
    }

    @Test
    public void get_translationsAreSet_translationsAreGot() {
        Locale locale = new Locale(
            test_message -> "Test Message",
            test_message2 -> "Test Message 2",
            test_message3 -> "Test Message 3"
        );

        Assert.assertEquals("Test Message", locale.get("test_message"));
        Assert.assertEquals("Test Message 2", locale.get("test_message2"));
        Assert.assertEquals("Test Message 3", locale.get("test_message3"));
        Assert.assertEquals("this_message_was_not_set", locale.get("this_message_was_not_set"));
    }

    @Test
    public void get_nullTranslationIsSet_nullTranslationIsGot() {
        Locale locale = new Locale(
            test_message -> null
        );

        Assert.assertNull(locale.get("test_message"));
    }

    @Test
    public void get_nullKeyIsAsked_nullTranslationIsGot() {
        Locale locale = new Locale(
            test_message -> "Test Message",
            test_message2 -> "Test Message 2",
            test_message3 -> "Test Message 3"
        );

        Assert.assertNull(locale.get(null));
    }

    @Test
    public void get_emptyKeyIsAsked_emptyKeyIsGot() {
        Locale locale = new Locale(
            test_message -> "Test Message",
            test_message2 -> "Test Message 2",
            test_message3 -> "Test Message 3"
        );

        Assert.assertEquals("", locale.get(""));
    }

    @Test
    public void getAll_translationsAreGiven_translationsAreGot() {

        Map<String, String> expectedTranslations = new HashMap<>();
        expectedTranslations.put("test_message", "Test Message");
        expectedTranslations.put("test_message2", "Test Message 2");
        expectedTranslations.put("test_message3", "Test Message 3");

        Map<String, String> actualTranslations = new Locale(
            test_message -> "Test Message",
            test_message2 -> "Test Message 2",
            test_message3 -> "Test Message 3"
        ).getAll();

        Assert.assertEquals(expectedTranslations, actualTranslations);
    }

}
