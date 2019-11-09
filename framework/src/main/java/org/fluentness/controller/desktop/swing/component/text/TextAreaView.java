package org.fluentness.controller.desktop.swing.component.text;

import javax.swing.*;

public class TextAreaView extends AbstractTextView<TextAreaView,JTextArea> {

    private final JTextArea jTextArea = new JTextArea();

    @Override
    public JTextArea getSwingView() {
        return jTextArea;
    }

    public TextAreaView columns(int columns) {
        jTextArea.setColumns(columns);
        return this;
    }

    public TextAreaView lineWrap(boolean wrap) {
        jTextArea.setLineWrap(wrap);
        return this;
    }

    public TextAreaView rows(int rows) {
        jTextArea.setRows(rows);
        return this;
    }

    public TextAreaView tabSize(int size) {
        jTextArea.setTabSize(size);
        return this;
    }

    public TextAreaView wrapStyleWord(boolean word) {
        jTextArea.setWrapStyleWord(word);
        return this;
    }

}
