package com.sample;

import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;

import static org.fluentness.Application.Platform.WEB;

public class WorkStation implements Application {

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new WorkStation()).on(WEB, args);
    }
}
