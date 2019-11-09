package org.fluentness.controller.desktop.swing.component.text.editor;

import javax.swing.*;

public class EditorPaneView extends AbstractTextEditorView<EditorPaneView, JEditorPane> {

    private final JEditorPane jEditorPane = new JEditorPane();

    @Override
    public JEditorPane getSwingView() {
        return jEditorPane;
    }

}
