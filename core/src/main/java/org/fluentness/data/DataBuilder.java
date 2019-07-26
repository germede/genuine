package org.fluentness.data;

import org.fluentness.base.common.ArchitectureBuilder;
import org.fluentness.base.common.exception.BuildException;
import org.fluentness.data.model.Repository;

public class DataBuilder extends ArchitectureBuilder<Data, Repository> {

    @Override
    protected void validate(Class<Repository> key, Repository value) throws BuildException {
        if (key.equals(Repository.class)) {
            throw new BuildException("Repository itself cannot be declared as a Repository");
        }
        if (instances.containsKey(key)) {
            throw new BuildException("Repository class %s was already defined");
        }
        if (key.isInterface()) {
            throw new BuildException("Repository class %s cannot be an interface");
        }
    }

    @Override
    public Data build() {
        return new Data(instances);
    }
}
