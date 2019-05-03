package org.fluentness.common;

import org.fluentness.logging.Logger;

import java.io.File;

public class Utils {
    public static void deleteDirectoryRecursively(File file) {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteDirectoryRecursively(entry);
                }
            }
        }
        if (!file.delete()) {
            Logger.warning(this.getClass(), "Cannot delete %s", file.getPath());
        } else {
            Logger.info(this.getClass(), "Deleted file %s", file.getPath());
        }
    }
}
