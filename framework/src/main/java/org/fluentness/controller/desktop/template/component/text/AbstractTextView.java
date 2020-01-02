package org.fluentness.controller.desktop.template.component.text;

import org.fluentness.controller.desktop.template.component.AbstractComponentView;

import javax.swing.*;
import javax.swing.event.CaretListener;
import javax.swing.plaf.TextUI;
import javax.swing.text.*;
import java.awt.*;

public abstract class AbstractTextView<Self extends AbstractTextView, View extends JTextComponent> extends AbstractComponentView<Self, View> {

    public AbstractTextView(View view) {
        super(view);
    }

    public Self caretListener(CaretListener listener) {
        view.addCaretListener(listener);
        return (Self) this;
    }

    public Self caret(Caret c) {
        view.setCaret(c);
        return (Self) this;
    }

    public Self caretColor(Color c) {
        view.setCaretColor(c);
        return (Self) this;
    }

    public Self caretPosition(int position) {
        view.setCaretPosition(position);
        return (Self) this;
    }

    public Self disabledTextColor(Color c) {
        view.setDisabledTextColor(c);
        return (Self) this;
    }

    public Self document(Document doc) {
        view.setDocument(doc);
        return (Self) this;
    }

    public Self dragEnabled(boolean b) {
        view.setDragEnabled(b);
        return (Self) this;
    }

    public Self dropMode(DropMode dropMode) {
        view.setDropMode(dropMode);
        return (Self) this;
    }

    public Self editable(boolean b) {
        view.setEditable(b);
        return (Self) this;
    }

    public Self focusAccelerator(char aKey) {
        view.setFocusAccelerator(aKey);
        return (Self) this;
    }

    public Self highlighter(Highlighter h) {
        view.setHighlighter(h);
        return (Self) this;
    }

    public Self keymap(Keymap map) {
        view.setKeymap(map);
        return (Self) this;
    }

    public Self margin(Insets m) {
        view.setMargin(m);
        return (Self) this;
    }

    public Self navigationFilter(NavigationFilter filter) {
        view.setNavigationFilter(filter);
        return (Self) this;
    }

    public Self selectedTextColor(Color c) {
        view.setSelectedTextColor(c);
        return (Self) this;
    }

    public Self selectionColor(Color c) {
        view.setSelectionColor(c);
        return (Self) this;
    }

    public Self selectionEnd(int selectionEnd) {
        view.setSelectionEnd(selectionEnd);
        return (Self) this;
    }

    public Self selectionStart(int selectionStart) {
        view.setSelectionStart(selectionStart);
        return (Self) this;
    }

    public Self text(String t) {
        view.setText(t);
        return (Self) this;
    }

    public Self uI(TextUI ui) {
        view.setUI(ui);
        return (Self) this;
    }

}
