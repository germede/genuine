package org.fluentness.form;


import org.fluentness.view.HtmlView;

public abstract class Field implements HtmlView {

    private boolean isRequired = false;
    private String type;

    public Field(String name, String type) {
        this.type = type;
    }


    public boolean isRequired() {
        return isRequired;
    }

    public Field setRequired(boolean required) {
        isRequired = required;
        return this;
    }

    public String getType() {
        return type;
    }

    @Override
    public String render() {
        return input(attrs(TYPE -> type, REQUIRED -> String.valueOf(isRequired))

        ).render();
    }
}
