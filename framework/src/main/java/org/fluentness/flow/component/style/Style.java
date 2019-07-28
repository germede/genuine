package org.fluentness.flow.component.style;

import org.fluentness.base.BaseConsumer;
import org.fluentness.base.service.logger.Logger;
import org.fluentness.flow.component.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public abstract class Style extends Component implements BaseConsumer {

    public void writeToFile(String path) {
        try {
            service(Logger.class).debug("Create CSS file %s", path);
            new File(path).getParentFile().mkdirs();
            Files.write(Paths.get(path),render().getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            service(Logger.class).error(e);
        }
    }

    abstract String render();

}
