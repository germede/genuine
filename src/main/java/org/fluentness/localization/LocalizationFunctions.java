package org.fluentness.localization;

import org.fluentness.FnAtoz;
import org.fluentness.controller.Controller;
import org.fluentness.controller.RequestRegister;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public interface LocalizationFunctions {

    default String translate(String name) {
        return "{{" + name + "}}";
    }

    default Locale getLocale() {
        return RequestRegister.getCurrent() != null ?
            RequestRegister.getCurrent().getPreferredLocale() :
            Locale.getDefault();
    }

}
