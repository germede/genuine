package org.fluentness.form;


import org.fluentness.rendering.MarkupElement;
import org.fluentness.rendering.Renderable;

import static org.fluentness.rendering.HtmlAttribute.TYPE;

public abstract class Field implements Renderable {

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
        return new MarkupElement("input",
                new CharSequence[]{
                        TYPE + type
                },
                false
        ).render();
    }
}
