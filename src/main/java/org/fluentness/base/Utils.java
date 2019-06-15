package org.fluentness.base;

import org.fluentness.base.logging.Log;

import java.io.File;

public enum Utils {

    INSTANCE;

    public void deleteRecursively(File file) {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteRecursively(entry);
                }
            }
        }
        if (file.exists()) {
            if (!file.delete()) {
                Log.INSTANCE.warning("Cannot delete %s", file.getPath());
            } else {
                Log.INSTANCE.debug("Deleted file %s", file.getPath());
            }
        }
    }

}
