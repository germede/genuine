package org.fluentness.view;

import org.fluentness.common.Provider;
import org.fluentness.localization.Localizable;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface ViewProvider extends Provider<View>, Localizable, MarkupFunctions {

    default String placeholder() {
        return "###PLACEHOLDER###";
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Template {
        String value();
    }
}
