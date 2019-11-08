package org.fluentness.controller.desktop.swing.component.text;

import javax.swing.*;
import java.awt.*;

public class TextAreaView extends AbstractTextView<TextAreaView,JTextArea> {

    JTextArea jTextArea = new JTextArea();

    @Override
    public JTextArea getView() {
        return jTextArea;
    }

    public TextAreaView columns(int columns) {
        jTextArea.setColumns(columns);
        return this;
    }

    public TextAreaView font(Font f) {
        jTextArea.setFont(f);
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
