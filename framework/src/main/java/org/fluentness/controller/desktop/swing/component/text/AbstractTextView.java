package org.fluentness.controller.desktop.swing.component.text;

import org.fluentness.controller.desktop.swing.component.AbstractComponentView;

import javax.swing.*;
import javax.swing.event.CaretListener;
import javax.swing.plaf.TextUI;
import javax.swing.text.*;
import java.awt.*;

public abstract class AbstractTextView<Self extends AbstractTextView, T extends JTextComponent> extends AbstractComponentView<Self, T> {

    @Override
    public abstract T getSwingView();

    public Self caretListener(CaretListener listener) {
        getSwingView().addCaretListener(listener);
        return (Self) this;
    }

    public Self caret(Caret c) {
        getSwingView().setCaret(c);
        return (Self) this;
    }

    public Self caretColor(Color c) {
        getSwingView().setCaretColor(c);
        return (Self) this;
    }

    public Self caretPosition(int position) {
        getSwingView().setCaretPosition(position);
        return (Self) this;
    }

    public Self disabledTextColor(Color c) {
        getSwingView().setDisabledTextColor(c);
        return (Self) this;
    }

    public Self document(Document doc) {
        getSwingView().setDocument(doc);
        return (Self) this;
    }

    public Self dragEnabled(boolean b) {
        getSwingView().setDragEnabled(b);
        return (Self) this;
    }

    public Self dropMode(DropMode dropMode) {
        getSwingView().setDropMode(dropMode);
        return (Self) this;
    }

    public Self editable(boolean b) {
        getSwingView().setEditable(b);
        return (Self) this;
    }

    public Self focusAccelerator(char aKey) {
        getSwingView().setFocusAccelerator(aKey);
        return (Self) this;
    }

    public Self highlighter(Highlighter h) {
        getSwingView().setHighlighter(h);
        return (Self) this;
    }

    public Self keymap(Keymap map) {
        getSwingView().setKeymap(map);
        return (Self) this;
    }

    public Self margin(Insets m) {
        getSwingView().setMargin(m);
        return (Self) this;
    }

    public Self navigationFilter(NavigationFilter filter) {
        getSwingView().setNavigationFilter(filter);
        return (Self) this;
    }

    public Self selectedTextColor(Color c) {
        getSwingView().setSelectedTextColor(c);
        return (Self) this;
    }

    public Self selectionColor(Color c) {
        getSwingView().setSelectionColor(c);
        return (Self) this;
    }

    public Self selectionEnd(int selectionEnd) {
        getSwingView().setSelectionEnd(selectionEnd);
        return (Self) this;
    }

    public Self selectionStart(int selectionStart) {
        getSwingView().setSelectionStart(selectionStart);
        return (Self) this;
    }

    public Self text(String t) {
        getSwingView().setText(t);
        return (Self) this;
    }

    public Self uI(TextUI ui) {
        getSwingView().setUI(ui);
        return (Self) this;
    }

}
