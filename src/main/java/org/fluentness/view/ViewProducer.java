package org.fluentness.view;

import org.fluentness.base.onion.Producer;
import org.fluentness.localization.LocalizationFunctions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class ViewProducer implements Producer<View>, LocalizationFunctions, MarkupFunctions {

    @Override
    public Class<View> getProducedComponentType() {
        return View.class;
    }

    static final String TEMPLATE_PLACEHOLDER = "###TEMPLATE_PLACEHOLDER###";

    protected String placeholder() {
        return TEMPLATE_PLACEHOLDER;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    protected @interface Template {
        String value();
    }
}
