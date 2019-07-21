package org.fluentness;

import org.junit.After;

public abstract class AbstractUnitTest {

    @After
    public void tearDown() {
        Fluentness.reset();
    }
}
