package org.fluentness.service.server;

import java.io.InputStream;
import java.sql.Date;
import java.util.Comparator;
import java.util.Locale;
import java.util.Map;

public interface Request {

    String getMethod();

    String getUri();

    Map<String, String> getHeaders();

    Map<String, String> getParameters();

    InputStream getInputStream();

    Response makeResponse(ResponseStatusCode statusCode, String mimeType, String body);

    default String[] getLanguages() {
        String languageList = getHeaders().getOrDefault(RequestHeader.ACCEPT_LANGUAGE, "");
        if (languageList.length() > 0) {
            return Locale.LanguageRange.parse(languageList)
                .stream()
                .sorted(Comparator.comparingDouble(Locale.LanguageRange::getWeight))
                .map(Locale.LanguageRange::getRange)
                .toArray(String[]::new);
        }
        return new String[]{"en"};
    }

    default Locale getLocale() {
        return Locale.forLanguageTag(getLanguages()[getLanguages().length - 1]);
    }

    default Object getParameter(Class tClass, String name) {
        Map<String, String> parameters = getParameters();
        if (Request.class.isAssignableFrom(tClass)) {
            return this;
        } else if (tClass.equals(String.class)) {
            return parameters.getOrDefault(name, "");
        } else if (int.class.isAssignableFrom(tClass)) {
            return parameters.containsKey(name) ? Integer.parseInt(parameters.get(name)) : 0;
        } else if (float.class.isAssignableFrom(tClass)) {
            return parameters.containsKey(name) ? Float.parseFloat(parameters.get(name)) : 0.0f;
        } else if (boolean.class.isAssignableFrom(tClass)) {
            return parameters.containsKey(name) && Boolean.parseBoolean(parameters.get(name));
        } else if (Date.class.isAssignableFrom(tClass)) {
            return parameters.containsKey(name) ? Date.parse(parameters.get(name)) : new Date(0);
        }
        return null;
    }
}
