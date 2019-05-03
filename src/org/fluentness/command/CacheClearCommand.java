package org.fluentness.command;

import org.fluentness.common.Utils;

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
        Utils.deleteDirectoryRecursively(new File("tmp/cache"));
    }


}
