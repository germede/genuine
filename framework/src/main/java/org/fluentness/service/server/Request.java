package org.fluentness.service.server;

import java.io.InputStream;
import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public interface Request {

    ThreadLocal<Request> CURRENT = new ThreadLocal<>();

    default String[] getSortedAcceptedLanguages() {
        List<String> languageList = getHeaders().get(RequestHeader.ACCEPT_LANGUAGE);
        if (languageList.size() > 0) {
            return Locale.LanguageRange.parse(languageList.get(0))
                .stream()
                .sorted(Comparator.comparingDouble(Locale.LanguageRange::getWeight))
                .map(Locale.LanguageRange::getRange)
                .toArray(String[]::new);
        }
        return new String[]{"en"};
    }

    Map<String, List<String>> getHeaders();

    String getMethod();

    URI getUri();

    InputStream getBody();

    Response makeResponse(int code);
}
