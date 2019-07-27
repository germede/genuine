package org.fluentness.data;

import org.fluentness.base.common.Architecture;
import org.fluentness.data.repository.Repository;

public class Data extends Architecture<Repository> {

    static Data instance;

    public Data() {
        instance = this;
    }

    @Override
    protected Class<? extends Repository>[] getKeysThatWillPointTo(Repository instance) {
        return array(
            instance.getModelClass(),
            instance.getClass()
        );
    }
}
