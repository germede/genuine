package org.fluentness.register;

import java.util.HashMap;
import java.util.Map;

public final class NamedValueRegister
{
    private final static Map<String, String> nameMap = new HashMap<>();

    public static boolean existsName(String lambdaClassName) {
        return nameMap.containsKey(lambdaClassName);
    }

    public static String getName(String lambdaClassName) {
        return nameMap.get(lambdaClassName);
    }

    public static void putName(String lambdaClassName, String name) {
        nameMap.put(lambdaClassName, name);
    }
}
