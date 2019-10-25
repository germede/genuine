package org.fluentness.backbone.architecture;

import org.fluentness.backbone.exception.DefinitionException;
import org.fluentness.service.Service;

public final class ServiceArchitecture extends AbstractArchitecture<Service> {

    private final static ServiceArchitecture INSTANCE = new ServiceArchitecture();

    static ServiceArchitecture getInstance() {
        return INSTANCE;
    }

    private ServiceArchitecture() {

    }

    @FunctionalInterface
    public interface Definer {
        void define(ServiceArchitecture serviceArchitecture) throws DefinitionException;
    }
}
