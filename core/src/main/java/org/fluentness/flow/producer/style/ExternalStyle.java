package org.fluentness.flow.producer.style;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExternalStyle extends Style {

    private String path;

    ExternalStyle(String path) {
        this.path = path;
    }

    @Override
    public String render() {
        try {
            return Files.readAllLines(Paths.get(path)).stream().reduce("",String::concat);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
