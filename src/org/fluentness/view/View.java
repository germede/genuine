package org.fluentness.view;

import org.fluentness.localization.Localizable;
import org.fluentness.logging.Logger;
import org.fluentness.rendering.ControlFlow;
import org.fluentness.rendering.HtmlAttribute;
import org.fluentness.rendering.HtmlElement;
import org.fluentness.rendering.HtmlHelpers;

import java.lang.reflect.Field;

public interface View {

    default View renderTakingTemplateIntoAccount() {
        try {
            if (this.getClass().isAnnotationPresent(Template.class)) {
                View template = this.getClass().getAnnotation(Template.class).value().newInstance();
                template.setPlaceholder(this);
                return template;
            }
        } catch (InstantiationException | IllegalAccessException e) {
            Logger.error(this.getClass(),e);
        }
        return this;
    }

    CharSequence render();

    default View setAttribute(String attribute, Object value) {
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals(attribute) && field.isAnnotationPresent(Attribute.class)) {
                    field.set(this, value);
                }
            }
        } catch (IllegalAccessException e) {
            Logger.error(this.getClass(), e);
        }
        return this;
    }


    default void setPlaceholder(View view) {
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Placeholder.class)) {
                    field.set(this, view);
                    break;
                }
            }
        } catch (IllegalAccessException e) {
            Logger.error(this.getClass(), e);
        }
    }

    interface Html extends View, HtmlElement, HtmlAttribute, HtmlHelpers, ControlFlow, Localizable {

    }

    interface Xml extends View {

    }
}
