package org.fluentness.service;

import org.fluentness.Fluentness;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class ServiceLoader {

    private static final String SERVICE_PREFIX = "META-INF/services/";
    private static final Set<String> SERVICES = new HashSet<>();

    public static void registerService(String interfaceFqcn) {
        SERVICES.add(interfaceFqcn);
    }

    static {
        registerService("org.fluentness.service.log.Log");
        registerService("org.fluentness.service.configuration.Configuration");
        registerService("org.fluentness.service.persistence.Persistence");
    }

    private final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    private final Map<Class, List<Class>> services = new HashMap<>();

    public ServiceLoader() {
        try {
            for (String className : SERVICES) {
                Class clazz = Class.forName(className);
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