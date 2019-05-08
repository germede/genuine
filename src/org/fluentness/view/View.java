package org.fluentness.view;

import org.fluentness.cacher.ViewCacher;
import org.fluentness.localization.Localizable;
import org.fluentness.logging.Logger;
import org.fluentness.rendering.FlowFunctions;
import org.fluentness.rendering.HtmlFunctions;
import org.fluentness.rendering.HtmlHelpers;
import org.fluentness.rendering.Renderable;

import java.lang.reflect.Field;

public interface View extends Renderable, Localizable {

    // rendering
    default String renderWithCacheAndTemplate(String language) {

        // with cache
        ViewCacher viewCacher = new ViewCacher(this, language);
        if (viewCacher.isCacheable()) {
            return viewCacher.cache();
        }

        // with template
        return getTemplate().render();
    }

    // render parent view if present, otherwise return itself
    default View getTemplate() {
        try {
            if (this.getClass().isAnnotationPresent(Template.class)) {
                View template = this.getClass().getAnnotation(Template.class).value().newInstance();
                template.setPlaceholder(this);
                return template;
            }
        } catch (InstantiationException | IllegalAccessException e) {
            Logger.error(this.getClass(), e);
        }
        return this;
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

    interface Html extends View, HtmlFunctions, HtmlHelpers, FlowFunctions {

    }

    interface Xml extends View {

    }
}
