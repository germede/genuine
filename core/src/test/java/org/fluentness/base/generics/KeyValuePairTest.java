package org.fluentness.base.generics;

import org.fluentness.Fluentness;
import org.fluentness.base.logger.LoggerImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class KeyValuePairTest {

    @Before
    public void before() {
        Fluentness.base.setLogger(mock(LoggerImpl.class));
    }

    @Test
    public void whenKeyValuePairIsSet_thenKeyAndValueAreGot() {
        KeyValuePair<String> stringKeyValuePair = theKey -> "theValue";

        Assert.assertEquals(stringKeyValuePair.getKey(), "theKey");
        Assert.assertEquals(stringKeyValuePair.getValue(), "theValue");
    }

    @Test
    public void whenKeyArg0IsSet_thenWarningIsLogged() {
        KeyValuePair<String> stringKeyValuePair = arg0 -> "theValue";


        Assert.assertEquals(stringKeyValuePair.getKey(), "arg0");
        verify(Fluentness.base.getLogger(), times(1)).warning(anyString());
    }

}
