package org.fluentness.common.caching;

import org.fluentness.common.logging.Log;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public interface Cache<T extends Cacheable> {

    String getIdentifyingCacheFilePath(T t);

    default boolean doesCacheFileExists(T t) {
        return new File(getIdentifyingCacheFilePath(t)).exists();
    }

    default void store(T t, String content) {
        try {
            Log.INSTANCE.debug("Create cache record %s", getIdentifyingCacheFilePath(t));
            new File(getIdentifyingCacheFilePath(t)).getParentFile().mkdirs();
            Files.write(Paths.get(getIdentifyingCacheFilePath(t)),content.getBytes(),StandardOpenOption.CREATE);
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
