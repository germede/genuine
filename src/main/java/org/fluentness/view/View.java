package org.fluentness.view;

import org.fluentness.cacher.ViewCacher;
import org.fluentness.localization.Localizable;
import org.fluentness.logger.Logger;
import org.fluentness.renderable.HtmlFunctions;
import org.fluentness.renderable.Renderable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

public interface View extends Localizable {

    Renderable getRenderable();

    // rendering
    default String renderWithCacheAndTemplate() {
        return ViewCacher.cache(getTemplate());
    }

    // return parent view if present, otherwise return itself
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

    interface Html extends View, HtmlFunctions {

    }

    interface Xml extends View {

    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Parameter {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Placeholder {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface Template {
        Class<? extends View> value();
    }
}
