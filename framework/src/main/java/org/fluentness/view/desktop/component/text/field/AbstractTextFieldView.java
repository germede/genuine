package org.fluentness.view.desktop.component.text.field;

import org.fluentness.view.desktop.component.text.AbstractTextView;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class AbstractTextFieldView<Self extends AbstractTextFieldView, View extends JTextField> extends AbstractTextView<Self, View> {

    public AbstractTextFieldView(View view) {
        super(view);
    }

    public Self actionListener(ActionListener l) {
        view.addActionListener(l);
        return (Self) this;
    }

    public Self columns(int columns) {
        view.setColumns(columns);
        return (Self) this;
    }

    public Self horizontalAlignment(int alignment) {
        view.setHorizontalAlignment(alignment);
        return (Self) this;
    }

    public Self scrollOffset(int scrollOffset) {
        view.setScrollOffset(scrollOffset);
        return (Self) this;
    }
}
