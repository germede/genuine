package org.fluentness.controller.desktop.swing.component.text.editor;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class TextPaneView extends AbstractTextEditorView<TextPaneView, JTextPane> {

    public TextPaneView() {
        super(new JTextPane());
    }

    public TextPaneView characterAttributes(AttributeSet attr, boolean replace) {
        view.setCharacterAttributes(attr, replace);
        return this;
    }

    public TextPaneView logicalStyle(Style s) {
        view.setLogicalStyle(s);
        return this;
    }

    public TextPaneView paragraphAttributes(AttributeSet attr, boolean replace) {
        view.setParagraphAttributes(attr, replace);
        return this;
    }

    public TextPaneView styledDocument(StyledDocument doc) {
        view.setStyledDocument(doc);
        return this;
    }
}
