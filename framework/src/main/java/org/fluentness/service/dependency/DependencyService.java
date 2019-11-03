package org.fluentness.service.dependency;

import org.fluentness.ApplicationComponent;
import org.fluentness.service.Service;

import java.util.List;

public interface DependencyService extends Service {
    <T extends ApplicationComponent> List<T> getInstances(Class<T> tClass);

    <T extends ApplicationComponent> T getInstance(Class<T> tClass);

    <T extends ApplicationComponent> void inject(List<Class<? extends T>> classes) throws InjectionException;

    <T extends ApplicationComponent> List<Class<? extends T>> loadClasses(String packageName, Class<T> parent) throws ClassLoadingException;
}
