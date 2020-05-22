package org.fluentness.service;

import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public final class ServiceLoader {

    private static final String SERVICE_PREFIX = "META-INF/services/";
    private static final Set<Class> SERVICES = new HashSet<>();

    public static void registerService(Class serviceInterface) {
        SERVICES.add(serviceInterface);
    }

    static {
        registerService(Log.class);
        registerService(Configuration.class);
        registerService(Persistence.class);
    }

    private final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    private final Map<Class, List<Class>> services = new HashMap<>();

    public ServiceLoader() {
        try {
            for (Class clazz : SERVICES) {
                services.put(clazz, loadImplementations(clazz));
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    private <S> List<Class> loadImplementations(Class<S> service) throws IOException, ClassNotFoundException {
        List<Class> implementations = new LinkedList<>();
        String servicePath = SERVICE_PREFIX + service.getName();
        Enumeration<URL> urls = classLoader.getResources(servicePath);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                line = line.trim();
                if (line.length() > 0 && line.charAt(0) != '#') {
                    Class<? extends S> e = (Class<? extends S>) Class.forName(line);
                    implementations.add(e);
                }
            }
        }
        return implementations;
    }

    public Map<Class, List<Class>> getServices() {
        return services;
    }
}