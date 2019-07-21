package org.fluentness.base.generics;

import org.fluentness.Fluentness;
import org.fluentness.base.logger.DefaultLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class KeyValuePairTest {

    @Before
    public void setUp() {
        Fluentness.base.setLogger(mock(DefaultLogger.class));
    }

    @Test
    public void getters_keyValuePairIsSet_keyAndValueAreGot() {
        KeyValuePair<String> stringKeyValuePair = theKey -> "theValue";

        Assert.assertEquals("theKey", stringKeyValuePair.getKey());
        Assert.assertEquals("theValue", stringKeyValuePair.getValue());
    }

    @Test
    public void getters_keyArg0IsSet_arg0IsGotAndWarningIsLogged() {
        KeyValuePair<String> stringKeyValuePair = arg0 -> "theValue";

        Assert.assertEquals("arg0", stringKeyValuePair.getKey());
        Assert.assertEquals("theValue", stringKeyValuePair.getValue());
        verify(Fluentness.base.getLogger(), times(1)).warning(anyString());
    }

}
