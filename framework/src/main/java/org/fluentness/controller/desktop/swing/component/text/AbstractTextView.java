package org.fluentness.controller.desktop.swing.component.text;

import org.fluentness.controller.desktop.swing.component.ComponentView;

import javax.swing.*;
import javax.swing.plaf.TextUI;
import javax.swing.text.*;
import java.awt.*;

public interface AbstractTextView<Self extends AbstractTextView, T extends JTextComponent> extends ComponentView<Self, T> {

    @Override
    T getView();

    default Self caret(Caret c) {
        getView().setCaret(c);
        return (Self) this;
    }

    default Self caretColor(Color c) {
        getView().setCaretColor(c);
        return (Self) this;
    }

    default Self caretPosition(int position) {
        getView().setCaretPosition(position);
        return (Self) this;
    }

    default Self componentOrientation(ComponentOrientation o) {
        getView().setComponentOrientation(o);
        return (Self) this;
    }

    default Self disabledTextColor(Color c) {
        getView().setDisabledTextColor(c);
        return (Self) this;
    }

    default Self document(Document doc) {
        getView().setDocument(doc);
        return (Self) this;
    }

    default Self dragEnabled(boolean b) {
        getView().setDragEnabled(b);
        return (Self) this;
    }

    default Self dropMode(DropMode dropMode) {
        getView().setDropMode(dropMode);
        return (Self) this;
    }

    default Self editable(boolean b) {
        getView().setEditable(b);
        return (Self) this;
    }

    default Self focusAccelerator(char aKey) {
        getView().setFocusAccelerator(aKey);
        return (Self) this;
    }

    default Self highlighter(Highlighter h) {
        getView().setHighlighter(h);
        return (Self) this;
    }

    default Self keymap(Keymap map) {
        getView().setKeymap(map);
        return (Self) this;
    }

    default Self margin(Insets m) {
        getView().setMargin(m);
        return (Self) this;
    }

    default Self navigationFilter(NavigationFilter filter) {
        getView().setNavigationFilter(filter);
        return (Self) this;
    }

    default Self selectedTextColor(Color c) {
        getView().setSelectedTextColor(c);
        return (Self) this;
    }

    default Self selectionColor(Color c) {
        getView().setSelectionColor(c);
        return (Self) this;
    }

    default Self selectionEnd(int selectionEnd) {
        getView().setSelectionEnd(selectionEnd);
        return (Self) this;
    }

    default Self selectionStart(int selectionStart) {
        getView().setSelectionStart(selectionStart);
        return (Self) this;
    }

    default Self text(String t) {
        getView().setText(t);
        return (Self) this;
    }

    default Self uI(TextUI ui) {
        getView().setUI(ui);
        return (Self) this;
    }

}
