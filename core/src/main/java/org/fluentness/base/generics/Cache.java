package org.fluentness.base.generics;

import org.fluentness.Fluentness;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.fluentness.base.config.BooleanKey.ENABLE_CACHE;

public interface Cache<T> {

    String getIdentifyingCacheFilePath(T t);

    boolean isCacheable(T t);

    default String cache(T t) {
        boolean cacheable = isCacheable(t);
        if (Fluentness.base.getConfig().get(ENABLE_CACHE) && doesCacheFileExists(t) && cacheable) {
            return retrieve(t);
        }

        String content = t.toString();
        if (Fluentness.base.getConfig().get(ENABLE_CACHE) && cacheable) {
            store(t, content);
        }
        return content;
    }

    default boolean doesCacheFileExists(T t) {
        return new File(getIdentifyingCacheFilePath(t)).exists();
    }

    default void store(T t, String content) {
        try {
            Fluentness.base.getLogger().fine("Create cache record %s", getIdentifyingCacheFilePath(t));
            new File(getIdentifyingCacheFilePath(t)).getParentFile().mkdirs();
            Files.write(Paths.get(getIdentifyingCacheFilePath(t)), content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            Fluentness.base.getLogger().severe(e);
        }
    }

    default String retrieve(T t) {
        try {
            Fluentness.base.getLogger().fine("Retrieve cache record %s", getIdentifyingCacheFilePath(t));
            return new String(Files.readAllBytes(Paths.get(getIdentifyingCacheFilePath(t))));
        } catch (IOException e) {
            Fluentness.base.getLogger().severe(e);
            return "";
        }
    }
}
