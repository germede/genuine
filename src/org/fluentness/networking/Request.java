package org.fluentness.networking;

import com.sun.net.httpserver.HttpExchange;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Request {

    private String method;
    private Map<String, String> getParameters;
    private Map<String, String> postParameters;

    public Request(HttpExchange httpExchange) {
        this.method = httpExchange.getRequestMethod();
        parseGetParameters(httpExchange);
        parsePostParameters(httpExchange);
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

    public String getMethod() {
        return method;
    }

    public String getGetParameter(String name) {
        return getParameters.getOrDefault(name, "");
    }

    public String getPostParameter(String name) {
        return postParameters.getOrDefault(name, "");
    }
}
