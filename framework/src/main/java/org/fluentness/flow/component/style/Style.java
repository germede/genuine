package org.fluentness.flow.component.style;

import org.fluentness.flow.component.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public abstract class Style extends Component {

    public void writeToFile(String path) {
        try {
            new File(path).getParentFile().mkdirs();
            Files.write(Paths.get(path),render().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
        }
    }

    abstract String render();

}
