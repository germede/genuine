package org.fluentness.view;

import org.fluentness.common.Provider;
import org.fluentness.localization.LocalizationFunctions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface ViewProvider extends Provider<View>, LocalizationFunctions, MarkupFunctions {

    String placeholder = "###PLACEHOLDER###";

    default String placeholder() {
        return placeholder;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Template {
        String value();
    }
}
