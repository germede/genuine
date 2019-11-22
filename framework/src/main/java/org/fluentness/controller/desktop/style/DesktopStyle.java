package org.fluentness.controller.desktop.style;

import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DesktopStyle {

    protected List<Style> styles = new LinkedList<>();

    public DesktopStyle(LookAndFeel lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    protected DesktopStyle(LookAndFeel lookAndFeel, Style[] styles) {
        this(lookAndFeel);
        this.styles = Arrays.asList(styles);
    }

    public List<Style> getStyles() {
        return styles;
    }
}
