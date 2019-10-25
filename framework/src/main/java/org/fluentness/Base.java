package org.fluentness;

import org.fluentness.base.Service;
import org.fluentness.backlog.Architecture;
import org.fluentness.base.exception.DefinitionException;

public final class Base extends Architecture<Service> {

    private final static Base INSTANCE = new Base();

    static Base getInstance() {
        return INSTANCE;
    }

    private Base() {

    }

    @FunctionalInterface
    public interface Definer {
        void define(Base base) throws DefinitionException;
    }
}
