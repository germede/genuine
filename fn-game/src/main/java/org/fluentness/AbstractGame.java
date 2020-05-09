package org.fluentness;

import org.fluentness.service.Service;
import org.fluentness.service.injection.Provider;
import org.fluentness.service.parser.ObjParser;

public abstract class AbstractGame implements Application {

    @Override
    public Provider<Service> services() {
        return Application.super.services()
            .add(ObjParser.class)
            ;
    }

    @Override
    public final void run(String[] args) throws Exception {

    }
}
