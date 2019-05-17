package org.fluentness.controller;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import org.fluentness.register.LocalizationRegister;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Request {

    private String method;
    private Headers headers;
    private String urlParameter;
    private Map<String, String> getParameters;
    private Map<String, String> postParameters;

    public Request(HttpExchange httpExchange, String declaredRoute) {
        this.method = httpExchange.getRequestMethod();
        this.headers = httpExchange.getRequestHeaders();
        parseUrlParameter(httpExchange, declaredRoute);
        parseGetParameters(httpExchange);
        parsePostParameters(httpExchange);
    }

    private void parseUrlParameter(HttpExchange httpExchange, String declaredRoute) {
        String path = httpExchange.getRequestURI().getPath();
        urlParameter = path.replace(declaredRoute.replaceAll("\\{.+",""),"");
    }

    private void parseGetParameters(HttpExchange httpExchange) {
        String query = httpExchange.getRequestURI().getQuery();
        getParameters = extractParametersFrom(query);

    }

    private void parsePostParameters(HttpExchange httpExchange) {
        String query = new BufferedReader(new InputStreamReader(httpExchange.getRequestBody())).lines()
                .parallel().collect(Collectors.joining("\n"));
        postParameters = extractParametersFrom(query);
    }

    private Map<String, String> extractParametersFrom(String query) {
        Map<String, String> parameters = new HashMap<>();
        if (query == null || query.isEmpty()) {
            return parameters;
        }
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 0) {
                if (entry.length > 1) {
                    parameters.put(entry[0], entry[1]);
                } else {
                    parameters.put(entry[0], "");
                }
            }
        }
        return parameters;
    }

    public Headers getHeaders() {
        return headers;
    }

    public String getMethod() {
        return method;
    }

    public String getUrlParameter() {
        return urlParameter;
    }

    public String getGetParameter(String name) {
        return getParameters.getOrDefault(name, "");
    }

    public String getPostParameter(String name) {
        return postParameters.getOrDefault(name, "");
    }

    public Locale getPreferredLocale() {
        if (headers.getFirst("Accept-Language") == null || headers.getFirst("Accept-Language").isEmpty()) {
            return Locale.getDefault();
        }
        List<Locale.LanguageRange> ranges = Locale.LanguageRange.parse(headers.getFirst("Accept-Language"));
        Collection<Locale> locales = LocalizationRegister.getLocales();
        return Locale.lookup(ranges, locales);
    }
}
