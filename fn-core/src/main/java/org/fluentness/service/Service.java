package org.fluentness.service;

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

}
