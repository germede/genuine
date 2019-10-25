package org.fluentness;

import org.fluentness.backlog.Architecture;
import org.fluentness.base.exception.DefinitionException;
import org.fluentness.data.Repository;

public final class Data extends Architecture<Repository> {

    private final static Data INSTANCE = new Data();

    static Data getInstance() {
        return INSTANCE;
    }

    private Data() {

    }

    @FunctionalInterface
    public interface Definer {
        void define(Data data) throws DefinitionException;
    }
}
