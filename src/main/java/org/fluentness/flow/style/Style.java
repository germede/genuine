package org.fluentness.flow.style;

import org.fluentness.common.generics.Component;
import org.fluentness.common.logging.Log;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public abstract class Style implements Component {

    public void writeToFile(String path) {
        try {
            Log.INSTANCE.debug("Create CSS file %s", path);
            new File(path).getParentFile().mkdirs();
            Files.write(Paths.get(path),render().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            Log.INSTANCE.error(e);
        }
    }

    abstract String render();

}
