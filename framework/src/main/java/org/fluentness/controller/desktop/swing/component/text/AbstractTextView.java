package org.fluentness.controller.desktop.swing.component.text;

import org.fluentness.controller.desktop.swing.component.AbstractComponentView;

import javax.swing.*;
import javax.swing.plaf.TextUI;
import javax.swing.text.*;
import java.awt.*;

public abstract class AbstractTextView<Self extends AbstractTextView, T extends JTextComponent> extends AbstractComponentView<Self, T> {

    public Self caret(Caret c) {
        getView().setCaret(c);
        return (Self) this;
    }

    public Self caretColor(Color c) {
        getView().setCaretColor(c);
        return (Self) this;
    }

    public Self caretPosition(int position) {
        getView().setCaretPosition(position);
        return (Self) this;
    }

    public Self componentOrientation(ComponentOrientation o) {
        getView().setComponentOrientation(o);
        return (Self) this;
    }

    public Self disabledTextColor(Color c) {
        getView().setDisabledTextColor(c);
        return (Self) this;
    }

    public Self document(Document doc) {
        getView().setDocument(doc);
        return (Self) this;
    }

    public Self dragEnabled(boolean b) {
        getView().setDragEnabled(b);
        return (Self) this;
    }

    public Self dropMode(DropMode dropMode) {
        getView().setDropMode(dropMode);
        return (Self) this;
    }

    public Self editable(boolean b) {
        getView().setEditable(b);
        return (Self) this;
    }

    public Self focusAccelerator(char aKey) {
        getView().setFocusAccelerator(aKey);
        return (Self) this;
    }

    public Self highlighter(Highlighter h) {
        getView().setHighlighter(h);
        return (Self) this;
    }

    public Self keymap(Keymap map) {
        getView().setKeymap(map);
        return (Self) this;
    }

    public Self margin(Insets m) {
        getView().setMargin(m);
        return (Self) this;
    }

    public Self navigationFilter(NavigationFilter filter) {
        getView().setNavigationFilter(filter);
        return (Self) this;
    }

    public Self selectedTextColor(Color c) {
        getView().setSelectedTextColor(c);
        return (Self) this;
    }

    public Self selectionColor(Color c) {
        getView().setSelectionColor(c);
        return (Self) this;
    }

    public Self selectionEnd(int selectionEnd) {
        getView().setSelectionEnd(selectionEnd);
        return (Self) this;
    }

    public Self selectionStart(int selectionStart) {
        getView().setSelectionStart(selectionStart);
        return (Self) this;
    }

    public Self text(String t) {
        getView().setText(t);
        return (Self) this;
    }

    public Self uI(TextUI ui) {
        getView().setUI(ui);
        return (Self) this;
    }

}
