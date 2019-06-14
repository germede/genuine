package org.fluentness.base.generics;

import org.fluentness.base.logging.Log;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public interface Cache<T> {

    default boolean isCacheable(T t) {
        return new File(getIdentifyingPath(t)).exists();
    }

    String getIdentifyingPath(T t);

    default void store(T t, String content) {
        try {
            Log.debug("Create cache record %s", getIdentifyingPath(t));
            new File(getIdentifyingPath(t)).getParentFile().mkdirs();
            Files.write(Paths.get(getIdentifyingPath(t)),content.getBytes(),StandardOpenOption.CREATE);
        } catch (IOException e) {
            Log.error(e);
        }
    }

    default String retrieve(T t) {
        try {
            Log.debug("Retrieve cache record %s", getIdentifyingPath(t));
            return new String(Files.readAllBytes(Paths.get(getIdentifyingPath(t))));
        } catch (IOException e) {
            Log.error(e);
            return "";
        }
    }
}
