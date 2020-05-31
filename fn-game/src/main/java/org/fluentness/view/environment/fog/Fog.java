package org.fluentness.view.environment.fog;

import org.fluentness.view.environment.Environment;

public class Fog implements Environment {

    public float density;
    public float gradient;

    public Fog(float density, float gradient) {
        this.density = density;
        this.gradient = gradient;
    }
}