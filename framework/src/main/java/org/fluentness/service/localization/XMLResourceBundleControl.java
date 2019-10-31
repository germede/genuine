package org.fluentness.service.localization;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

class XMLResourceBundleControl extends ResourceBundle.Control {

    public List<String> getFormats(String baseName) {
        return Collections.singletonList("xml");
    }

    public ResourceBundle newBundle(String baseName,
                                    Locale locale,
                                    String format,
                                    ClassLoader loader,
                                    boolean reload) throws IOException {
        return new XMLResourceBundle(
            getClass().getClassLoader().getResourceAsStream(
                toResourceName(
                    toBundleName(baseName, locale),
                    format
                )
            )
        );
    }

}

