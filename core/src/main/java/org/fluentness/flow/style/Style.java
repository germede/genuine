package org.fluentness.flow.style;

import org.fluentness.Fluentness;
import org.fluentness.base.generics.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public abstract class Style extends Component {

    public void writeToFile(String path) {
        try {
            Fluentness.base.getLogger().fine("Create CSS file %s", path);
            new File(path).getParentFile().mkdirs();
            Files.write(Paths.get(path),render().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            Fluentness.base.getLogger().severe(e);
        }
    }

    abstract String render();

}
