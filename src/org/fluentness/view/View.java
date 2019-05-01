package org.fluentness.view;

import org.fluentness.caching.ViewCacher;
import org.fluentness.localization.Localizable;
import org.fluentness.localization.ViewLocalizator;
import org.fluentness.logging.Log;
import org.fluentness.rendering.ControlFlow;
import org.fluentness.rendering.HtmlAttribute;
import org.fluentness.rendering.HtmlElement;
import org.fluentness.rendering.HtmlHelpers;

import java.lang.reflect.Field;

public interface View {

    // rendering
    default String renderWithCacheAndTemplateAndLocalization(String language) {

        // with cache
        ViewCacher viewCacher = new ViewCacher(this, language);
        if (viewCacher.isCacheable()) {
            return viewCacher.cache();
        }

        // with template
        String result = getTemplate().render().toString();

        // with localization
        result = new ViewLocalizator(language).localize(result);

        return result;
    }

    CharSequence render();

    // render parent view if present, otherwise return itself
    default View getTemplate() {
        try {
            if (this.getClass().isAnnotationPresent(Template.class)) {
                View template = this.getClass().getAnnotation(Template.class).value().newInstance();
                template.setPlaceholder(this);
                return template;
            }
        } catch (InstantiationException | IllegalAccessException e) {
            Log.error(this.getClass(), e);
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
            Log.error(this.getClass(), e);
        }
    }

    default View setAttribute(String attribute, Object value) {
        try {
            Field[] fields = this.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals(attribute) && field.isAnnotationPresent(Attribute.class)) {
                    field.set(this, value);
                }
            }
        } catch (IllegalAccessException e) {
            Log.error(this.getClass(), e);
        }
        return this;
    }

    // view types
    interface Html extends View, HtmlElement, HtmlAttribute, HtmlHelpers, ControlFlow, Localizable {

    }

    interface Xml extends View {

    }
}
