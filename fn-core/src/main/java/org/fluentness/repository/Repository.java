package org.fluentness.repository;

import org.fluentness.ApplicationComponent;
import org.fluentness.model.Model;

public interface Repository<M extends Model> extends ApplicationComponent {

    Class<M> getModelClass();


}
