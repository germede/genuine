package org.fluentness.controller.desktop.swing.component.text.field;

import org.fluentness.controller.desktop.swing.component.text.AbstractTextView;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class AbstractTextFieldView<Self extends AbstractTextFieldView, T extends JTextField> extends AbstractTextView<Self, T> {

    @Override
    public abstract T getSwingView();

    public Self actionListener(ActionListener l) {
        getSwingView().addActionListener(l);
        return (Self) this;
    }

    public Self columns(int columns) {
        getSwingView().setColumns(columns);
        return (Self) this;
    }

    public Self horizontalAlignment(int alignment) {
        getSwingView().setHorizontalAlignment(alignment);
        return (Self) this;
    }

    public Self scrollOffset(int scrollOffset) {
        getSwingView().setScrollOffset(scrollOffset);
        return (Self) this;
    }
}
