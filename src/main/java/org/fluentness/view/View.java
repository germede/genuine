package org.fluentness.view;

import org.fluentness.cacher.ViewCacher;
import org.fluentness.localization.Localizable;
import org.fluentness.logging.Logger;
import org.fluentness.rendering.FlowFunctions;
import org.fluentness.rendering.HtmlFunctions;
import org.fluentness.rendering.HtmlHelpers;
import org.fluentness.rendering.Renderable;

import java.lang.reflect.Field;

public interface View extends Localizable {

    Renderable getRenderable();

    // rendering
    default String renderWithCacheAndTemplate(String language) {

        // with cache
        ViewCacher viewCacher = new ViewCacher(this, language);
        if (viewCacher.isCacheable()) {
            return viewCacher.cache();
        }

        // with template
        return getTemplate().getRenderable().render();
    }

    // render parent view if present, otherwise return itself
    default View getTemplate() {
        try {
            if (this.getClass().isAnnotationPresent(Template.class)) {
                View template = this.getClass().getAnnotation(Template.class).value().newInstance();
                template.injectPlaceholder(this);
                return template;
            }
        } catch (InstantiationException | IllegalAccessException e) {
            Logger.error(this.getClass(), e);
        }
        return this;
    }

    default View injectAttribute(String name, Object value) {
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                if (field.getName().equals(name) && field.isAnnotationPresent(Parameter.class)) {
                    field.setAccessible(true);
                    field.set(this, value);
                    field.setAccessible(false);
                }
            }
        } catch (IllegalAccessException e) {
            Logger.error(this.getClass(), e);
        }
        return this;
    }

    default void injectPlaceholder(View view) {
        try {
            for (Field field : this.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Placeholder.class)) {
                    field.setAccessible(true);
                    field.set(this, view);
                    field.setAccessible(false);
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
