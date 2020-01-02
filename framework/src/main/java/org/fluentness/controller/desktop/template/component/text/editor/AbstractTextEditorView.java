package org.fluentness.controller.desktop.template.component.text.editor;

import org.fluentness.controller.desktop.template.component.text.AbstractTextView;

import javax.swing.*;
import javax.swing.text.EditorKit;
import java.io.IOException;
import java.net.URL;

public abstract class AbstractTextEditorView<Self extends AbstractTextEditorView, View extends JEditorPane> extends AbstractTextView<Self, View> {

    public AbstractTextEditorView(View view) {
        super(view);
    }

    public Self contentType(String type) {
        view.setContentType(type);
        return (Self) this;
    }

    public Self editorKit(EditorKit kit) {
        view.setEditorKit(kit);
        return (Self) this;
    }

    public Self editorKitForContentType(String type, EditorKit k) {
        view.setEditorKitForContentType(type, k);
        return (Self) this;
    }

    public Self page(String url) throws IOException {
        view.setPage(url);
        return (Self) this;
    }

    public Self page(URL page) throws IOException {
        view.setPage(page);
        return (Self) this;
    }
}
