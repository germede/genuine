package org.fluentness.common;

import org.fluentness.logging.Logger;

import java.io.File;

public final class Utils {
    public static void deleteDirectoryRecursively(File file) {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteDirectoryRecursively(entry);
                }
            }
        }
        if (file.exists()) {
            if (!file.delete()) {
                Logger.warning(Utils.class, "Cannot delete %s", file.getPath());
            } else {
                Logger.debug(Utils.class, "Deleted file %s", file.getPath());
            }
        }
    }

    public static String toTitelCase(String string) {
        return string.substring(0,1).toUpperCase().concat(string.substring(1));
    }
}
