package org.fluentness.repository;

import java.util.Collection;

public interface Repository<M> {

    Collection<M> selectAll();

}
