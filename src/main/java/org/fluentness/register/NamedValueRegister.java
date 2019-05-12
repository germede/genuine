package org.fluentness.register;

import java.util.HashMap;
import java.util.Map;

public final class NamedValueRegister
{
    private final static Map<String, String> map = new HashMap<>();

    public static void put(String lambdaClassName, String name) {
        map.put(lambdaClassName, name);
    }

    public static boolean exists(String lambdaClassName) {
        return map.containsKey(lambdaClassName);
    }

    public static String get(String lambdaClassName) {
        return map.get(lambdaClassName);
    }
}
