package org.fluentness.flow;

import org.fluentness.Fluentness;
import org.fluentness.IsolatedUnitTest;
import org.junit.Test;

public class FlowTest extends IsolatedUnitTest {

    @Test(expected = NullPointerException.class)
    public void whenNoClassIsGiven_thenNullPointerExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fluentness.flow.instantiateProvider(null, null);
    }

    @Test(expected = ClassNotFoundException.class)
    public void whenAbsentClassIsGiven_thenClassNotFoundExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fluentness.flow.instantiateProvider(String.class, "this.class.does.not.Exist");
    }

    @Test(expected = IllegalAccessException.class)
    public void whenPrivateClassIsGiven_thenIllegalAccessExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fluentness.flow.instantiateProvider(Number.class, "java.lang.String");
    }

    @Test(expected = ClassCastException.class)
    public void whenIncorrectClassTypeIsGiven_thenClassCastExceptionIsThrown()
        throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fluentness.flow.instantiateProvider(Number.class, "java.lang.String");

    }
}
