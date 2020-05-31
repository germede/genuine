package org.fluentness.view.component.text;

public interface Heading extends Text {

    enum Level {
        H1, H2, H3, H4, H5, H6
    }

    Level getLevel();

}
