package org.fluentness.service.dependency;

import org.fluentness.ApplicationComponent;
import org.fluentness.Fluentness;
import org.fluentness.service.Service;

import java.util.List;

public interface DependencyService extends Service {
    <A extends ApplicationComponent> List<A> getInstances(Class<A> tClass);

    <A extends ApplicationComponent> A getInstance(Class<A> tClass);

    <A extends ApplicationComponent> void inject(Fluentness proxy, List<Class<? extends A>> classes) throws InjectionException;

    <A extends ApplicationComponent> List<Class<? extends A>> loadClasses(String packageName, Class<A> parent) throws ClassLoadingException;
}
