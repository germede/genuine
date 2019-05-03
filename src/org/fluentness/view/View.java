package org.fluentness.view;

import org.fluentness.caching.ViewCacher;
import org.fluentness.localization.Localizable;
import org.fluentness.localization.ViewLocalizator;
import org.fluentness.logging.Log;
import org.fluentness.rendering.*;

import java.lang.reflect.Field;

public interface View extends Renderable {

    // rendering
    default String renderWithCacheAndTemplateAndLocalization(String language) {

        // with cache
        ViewCacher viewCacher = new ViewCacher(this, language);
        if (viewCacher.isCacheable()) {
            return viewCacher.cache();
        }

        // with template
        String result = getTemplate().render();

        // with localization
        result = new ViewLocalizator(language).localize(result);

        return result;
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
            Log.severe(this.getClass(), e);
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
            Log.severe(this.getClass(), e);
        }
    }

    // view types
    interface Html extends View, HtmlElement, HtmlAttribute, HtmlHelpers, ControlFlowFunctions, Localizable {

    }

    interface Xml extends View {

    }
}
