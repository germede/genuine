package com.sample;

import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.mobile.FnActivity;
import org.fluentness.service.Service;
import org.fluentness.service.persistence.JdbcPersistence;

import java.util.List;

import static org.fluentness.Application.Platform.DESKTOP;

public class WorkStation implements Application {

    static {
        FnActivity.application = new WorkStation();
    }

    @Override
    public List<Class<? extends Service>> getServices() {
        List<Class<? extends Service>> load = load(Service.class);
        //load.add(JdbcPersistence.class);
        return load;
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new WorkStation()).on(DESKTOP, args);
    }
}
