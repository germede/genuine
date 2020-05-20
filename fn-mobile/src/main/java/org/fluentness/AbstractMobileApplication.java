package org.fluentness;

import org.fluentness.service.Services;
import org.fluentness.service.log.AndroidLog;
import org.fluentness.service.persistence.AndroidPersistence;

@Services({
    AndroidLog.class,
    AndroidPersistence.class,
})
public abstract class AbstractMobileApplication implements Application {

    @Override
    public void run(String[] args) throws Exception {

    }
}
