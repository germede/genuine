package org.fluentness.controller.desktop.view.component.text;

import javax.swing.*;

public class TextAreaView extends AbstractTextView<TextAreaView,JTextArea> {

    public TextAreaView() {
        super(new JTextArea());
    }

    public TextAreaView columns(int columns) {
        view.setColumns(columns);
        return this;
    }

    public TextAreaView lineWrap(boolean wrap) {
        view.setLineWrap(wrap);
        return this;
    }

    public TextAreaView rows(int rows) {
        view.setRows(rows);
        return this;
    }

    public TextAreaView tabSize(int size) {
        view.setTabSize(size);
        return this;
    }

    public TextAreaView wrapStyleWord(boolean word) {
        view.setWrapStyleWord(word);
        return this;
    }

}
