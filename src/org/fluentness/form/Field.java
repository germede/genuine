package org.fluentness.form;


import org.fluentness.rendering.Renderable;
import org.fluentness.view.View;

public abstract class Field implements View.Html {

    private boolean required = false;
    private String type;
    private String name;

    public Field(String type) {
        this.type = type;
    }

    public Field required() {
        this.required = true;
        return this;
    }

    Field setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Renderable getRenderable() {
        return input(
                TYPE -> type,
                REQUIRED -> String.valueOf(required),
                NAME -> name
        );
    }
}
