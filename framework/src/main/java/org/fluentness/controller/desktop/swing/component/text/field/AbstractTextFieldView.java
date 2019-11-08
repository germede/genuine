package org.fluentness.controller.desktop.swing.component.text.field;

import org.fluentness.controller.desktop.swing.component.text.AbstractTextView;

import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;

public abstract class AbstractTextFieldView<Self extends AbstractTextFieldView, T extends JTextField> extends AbstractTextView<Self, T> {

    public Self action(Action a) {
        getView().setAction(a);
        return (Self) this;
    }

    public Self actionCommand(String command) {
        getView().setActionCommand(command);
        return (Self) this;
    }

    public Self columns(int columns) {
        getView().setColumns(columns);
        return (Self) this;
    }

    public Self document(Document doc) {
        getView().setDocument(doc);
        return (Self) this;
    }

    public Self font(Font f) {
        getView().setFont(f);
        return (Self) this;
    }

    public Self horizontalAlignment(int alignment) {
        getView().setHorizontalAlignment(alignment);
        return (Self) this;
    }

    public Self scrollOffset(int scrollOffset) {
        getView().setScrollOffset(scrollOffset);
        return (Self) this;
    }
}
