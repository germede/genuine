package org.fluentness.controller.desktop.swing.component.text.editor;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class TextPaneView extends AbstractTextEditorView<TextPaneView, JTextPane> {

    private final JTextPane jTextPane = new JTextPane();

    @Override
    public JTextPane getSwingView() {
        return jTextPane;
    }

    public TextPaneView characterAttributes(AttributeSet attr, boolean replace) {
        jTextPane.setCharacterAttributes(attr, replace);
        return this;
    }

    public TextPaneView logicalStyle(Style s) {
        jTextPane.setLogicalStyle(s);
        return this;
    }

    public TextPaneView paragraphAttributes(AttributeSet attr, boolean replace) {
        jTextPane.setParagraphAttributes(attr, replace);
        return this;
    }

    public TextPaneView styledDocument(StyledDocument doc) {
        jTextPane.setStyledDocument(doc);
        return this;
    }
}
