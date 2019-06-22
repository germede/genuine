package org.fluentness.common.generics;

import org.fluentness.Settings;
import org.fluentness.common.logging.Log;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static org.fluentness.common.constants.Settings.CACHE_ENABLE;

public interface Cache<T> {

    String getIdentifyingCacheFilePath(T t);

    boolean isCacheable(T t);

    default String cache(T t) {
        boolean cacheable = isCacheable(t);
        if (Settings.INSTANCE.getBoolean(CACHE_ENABLE) && doesCacheFileExists(t) && cacheable) {
            return retrieve(t);
        }

        String content = t.toString();
        if (Settings.INSTANCE.getBoolean(CACHE_ENABLE) && cacheable) {
            store(t, content);
        }
        return content;
    }

    default boolean doesCacheFileExists(T t) {
        return new File(getIdentifyingCacheFilePath(t)).exists();
    }

    default void store(T t, String content) {
        try {
            Log.INSTANCE.debug("Create cache record %s", getIdentifyingCacheFilePath(t));
            new File(getIdentifyingCacheFilePath(t)).getParentFile().mkdirs();
            Files.write(Paths.get(getIdentifyingCacheFilePath(t)), content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            Log.INSTANCE.error(e);
        }
    }

    default String retrieve(T t) {
        try {
            Log.INSTANCE.debug("Retrieve cache record %s", getIdentifyingCacheFilePath(t));
            return new String(Files.readAllBytes(Paths.get(getIdentifyingCacheFilePath(t))));
        } catch (IOException e) {
            Log.INSTANCE.error(e);
            return "";
        }
    }
}
