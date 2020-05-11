package org.fluentness;

import org.fluentness.service.Service;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.log.AndroidLog;
import org.fluentness.service.persistence.AndroidPersistence;

public abstract class AbstractMobileApplication implements Application {

    @Override
    public Provider<Service> services() {
        return Application.super.services()
            .add(AndroidLog.class)
            .add(AndroidPersistence.class)
            ;
    }

    @Override
    public void run(String[] args) throws Exception {

    }
}
