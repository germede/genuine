package org.fluentness.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface Service {

    static Class<? extends Service> getServiceInterface(Class aClass) {
        if (!Service.class.isAssignableFrom(aClass)) return aClass;
        do {
            for (Class anInterface : aClass.getInterfaces()) {
                if (anInterface.equals(Service.class)) return aClass;
                if (Service.class.isAssignableFrom(anInterface)) return anInterface;
            }
        } while ((aClass = aClass.getSuperclass()) != null);
        return Service.class;
    }

    default Class<? extends Service> getServiceInterface() {
        return getServiceInterface(this.getClass());
    }

    // By using this annotation on the service interface,
    // multiple implementations will be instantiated when needed and injected when ServiceClass[] constructor parameter
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface MultiService {
    }
}
