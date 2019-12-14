package org.fluentness.injector;

import java.util.List;

public interface Injector {

    <A> List<A> getInstances(Class<A> parent);

    <A> A getInstance(Class<A> parent);
}
