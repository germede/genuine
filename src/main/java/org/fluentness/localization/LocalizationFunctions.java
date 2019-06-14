package org.fluentness.localization;

import org.fluentness.controller.RequestRegister;

import java.util.Locale;

public interface LocalizationFunctions {

    default String translate(String name) {
        return "{{" + name + "}}";
    }

    default Locale getLocale() {
        return RequestRegister.INSTANCE.get(Thread.currentThread()) != null ?
            RequestRegister.INSTANCE.get(Thread.currentThread()).getPreferredLocale() :
            Locale.getDefault();
    }

}
