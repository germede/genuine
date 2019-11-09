package org.fluentness.controller.desktop.swing.component.text.editor;

import org.fluentness.controller.desktop.swing.component.text.AbstractTextView;

import javax.swing.*;
import javax.swing.text.EditorKit;
import java.io.IOException;
import java.net.URL;

public abstract class AbstractTextEditorView<Self extends AbstractTextEditorView, T extends JEditorPane> extends AbstractTextView<Self, T> {

    @Override
    public abstract T getSwingView();

    public Self contentType(String type) {
        getSwingView().setContentType(type);
        return (Self) this;
    }

    public Self editorKit(EditorKit kit) {
        getSwingView().setEditorKit(kit);
        return (Self) this;
    }

    public Self editorKitForContentType(String type, EditorKit k) {
        getSwingView().setEditorKitForContentType(type, k);
        return (Self) this;
    }

    public Self page(String url) throws IOException {
        getSwingView().setPage(url);
        return (Self) this;
    }

    public Self page(URL page) throws IOException {
        getSwingView().setPage(page);
        return (Self) this;
    }
}
