package org.fluentness;

import org.junit.Assert;
import org.junit.Test;

public class FluentnessTest {

    @Test
    public void staticFields_noneIsDone_baseDataAndFlowAreAlreadyStaticallySet() {
        Assert.assertNotNull(Fluentness.getBase());
        Assert.assertNotNull(Fluentness.getData());
        Assert.assertNotNull(Fluentness.getFlow());
    }

}
