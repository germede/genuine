package org.fluentness.controller.desktop.template.component.text.editor;

import javax.swing.*;

public class EditorPaneView extends AbstractTextEditorView<EditorPaneView, JEditorPane> {

    public EditorPaneView() {
        super(new JEditorPane());
    }

}
