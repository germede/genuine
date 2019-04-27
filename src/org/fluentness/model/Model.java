package org.fluentness.model;

import org.fluentness.repository.RepositoryImpl;

public interface Model {

    default int create() {
        return RepositoryImpl.create(this, this.getClass());
    }

    default int update() {
        return RepositoryImpl.update(this, this.getClass());
    }

    default int delete() {
        return RepositoryImpl.delete(this, this.getClass());
    }
}
