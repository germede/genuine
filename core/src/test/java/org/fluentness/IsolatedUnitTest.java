package org.fluentness;

import org.junit.After;

public abstract class IsolatedUnitTest {

    @After
    public void tearDown() {
        Fluentness.reset();
    }
}
