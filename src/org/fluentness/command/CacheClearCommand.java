package org.fluentness.command;

import org.fluentness.logging.Logger;

import java.io.File;

public class CacheClearCommand implements Command {
    @Override
    public String getName() {
        return "cache:clear";
    }

    @Override
    public String getDescription() {
        return "Clears the view cache by deleting directory tmp/cache";
    }

    @Override
    public void execute(Parameters parameters) {
        deleteDirectoryRecursively(new File("tmp/cache"));
    }

    private void deleteDirectoryRecursively(File file) {
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
