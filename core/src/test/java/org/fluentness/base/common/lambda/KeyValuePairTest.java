package org.fluentness.base.common.lambda;

import org.junit.Assert;
import org.junit.Test;

public class KeyValuePairTest {

    @Test
    public void getters_keyValuePairIsSet_keyAndValueAreGot() {
        KeyValuePair<String> stringKeyValuePair = theKey -> "theValue";

        Assert.assertEquals("theKey", stringKeyValuePair.getKey());
        Assert.assertEquals("theValue", stringKeyValuePair.getValue());
    }

    @Test
    public void getters_keyArg0IsSet_nullIsReturned() {
        KeyValuePair<String> stringKeyValuePair = arg0 -> "theValue";

        Assert.assertNull(stringKeyValuePair.getKey());
        Assert.assertEquals("theValue", stringKeyValuePair.getValue());
    }

}
