package org.fluentness;

import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.log.AndroidLog;
import org.fluentness.service.persistence.AndroidPersistence;

public abstract class AbstractMobileApplication implements Application {

    @Override
    public void provide(Provider provider) {
        provider
            .service(AndroidLog.class)
            .service(AndroidPersistence.class);
    }

    @Override
    public void configure(Configuration configuration) {

    }

    @Override
    public void run(String[] args) throws Exception {

    }
}
