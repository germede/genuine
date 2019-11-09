package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.plaf.ColorChooserUI;
import java.awt.*;

public class ColorChooserView extends AbstractComponentView<ColorChooserView, JColorChooser> {

    private final JColorChooser jColorChooser = new JColorChooser();

    @Override
    public JColorChooser getSwingView() {
        return jColorChooser;
    }

    public ColorChooserView chooserPanels(AbstractColorChooserPanel... panels) {
        jColorChooser.setChooserPanels(panels);
        return this;
    }

    public ColorChooserView color(Color color) {
        jColorChooser.setColor(color);
        return this;
    }

    public ColorChooserView color(int c) {
        jColorChooser.setColor(c);
        return this;
    }

    public ColorChooserView color(int r, int g, int b) {
        jColorChooser.setColor(r, g, b);
        return this;
    }

    public ColorChooserView dragEnabled(boolean b) {
        jColorChooser.setDragEnabled(b);
        return this;
    }

    public ColorChooserView previewPanel(JComponent preview) {
        jColorChooser.setPreviewPanel(preview);
        return this;
    }

    public ColorChooserView selectionModel(ColorSelectionModel newModel) {
        jColorChooser.setSelectionModel(newModel);
        return this;
    }

    public ColorChooserView uI(ColorChooserUI ui) {
        jColorChooser.setUI(ui);
        return this;
    }
}
