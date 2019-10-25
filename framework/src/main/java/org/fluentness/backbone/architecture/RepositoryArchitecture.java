package org.fluentness.backbone.architecture;

import org.fluentness.backbone.exception.DefinitionException;
import org.fluentness.repository.Repository;

public final class RepositoryArchitecture extends AbstractArchitecture<Repository> {

    private final static RepositoryArchitecture INSTANCE = new RepositoryArchitecture();

    static RepositoryArchitecture getInstance() {
        return INSTANCE;
    }

    private RepositoryArchitecture() {

    }

    @FunctionalInterface
    public interface Definer {
        void define(RepositoryArchitecture repositoryArchitecture) throws DefinitionException;
    }
}
