package org.fluentness.service.server;

import java.io.InputStream;
import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public interface Request {

    default String[] getLanguages() {
        List<String> languageList = getHeaders().get(RequestHeader.ACCEPT_LANGUAGE.toString());
        if (languageList.size() > 0) {
            return Locale.LanguageRange.parse(languageList.get(0))
                .stream()
                .sorted(Comparator.comparingDouble(Locale.LanguageRange::getWeight))
                .map(Locale.LanguageRange::getRange)
                .toArray(String[]::new);
        }
        return new String[]{"en"};
    }

    default String getHeader(RequestHeader requestHeader) {
        List<String> elements = getHeaders().get(requestHeader.toString());
        return elements != null ? String.join("", elements) : null;
    }

    default Response makeResponse(ResponseStatusCode code) {
        return makeResponse(code.toInt());
    }

    Map<String, List<String>> getHeaders();

    RequestMethod getMethod();

    URI getUri();

    InputStream getBody();

    Response makeResponse(int code);
}
