package org.fluentness.controller.desktop.style;

import org.fluentness.controller.desktop.style.property.Property;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

public class DesktopStyle {

    public static DesktopStyle basedOn(String lookAndFeelClassName) {
        return new DesktopStyle(lookAndFeelClassName);
    }

    public static DesktopStyle basedOn(LookAndFeel lookAndFeel) {
        return new DesktopStyle(lookAndFeel);
    }

    private List<Property> properties = new LinkedList<>();

    private DesktopStyle(LookAndFeel lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private DesktopStyle(String lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public List<Property> getProperties() {
        return properties;
    }

    public DesktopStyle forTag() {
//
//        public static <S extends Container > Property<S,> byClass(Class<S> swingClass, PropertyLambda<S> styleLambda) {
//            return new Property(swingClass, styleLambda);
//        }
//        properties.add();
        return this;
    }
}
