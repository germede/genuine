package org.fluentness.view.desktop.component;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.plaf.ColorChooserUI;
import java.awt.*;

public class ColorChooserView extends AbstractComponentView<ColorChooserView, JColorChooser> {
    
    public ColorChooserView() {
        super(new JColorChooser());
    }

    public ColorChooserView chooserPanels(AbstractColorChooserPanel... panels) {
        view.setChooserPanels(panels);
        return this;
    }

    public ColorChooserView color(Color color) {
        view.setColor(color);
        return this;
    }

    public ColorChooserView color(int c) {
        view.setColor(c);
        return this;
    }

    public ColorChooserView color(int r, int g, int b) {
        view.setColor(r, g, b);
        return this;
    }

    public ColorChooserView dragEnabled(boolean b) {
        view.setDragEnabled(b);
        return this;
    }

    public ColorChooserView previewPanel(JComponent preview) {
        view.setPreviewPanel(preview);
        return this;
    }

    public ColorChooserView selectionModel(ColorSelectionModel newModel) {
        view.setSelectionModel(newModel);
        return this;
    }

    public ColorChooserView uI(ColorChooserUI ui) {
        view.setUI(ui);
        return this;
    }
}
