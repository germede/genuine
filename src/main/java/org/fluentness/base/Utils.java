package org.fluentness.base;

import org.fluentness.base.logging.Log;

import java.io.File;

public enum Utils {

    instance;

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
                Log.instance.warning("Cannot delete %s", file.getPath());
            } else {
                Log.instance.debug("Deleted file %s", file.getPath());
            }
        }
    }

}
