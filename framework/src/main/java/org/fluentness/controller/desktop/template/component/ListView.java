package org.fluentness.controller.desktop.template.component;

import javax.swing.*;
import javax.swing.plaf.ListUI;
import java.awt.*;
import java.util.Vector;

public class ListView<E> extends AbstractComponentView<ListView, JList> {

    public ListView() {
        super(new JList());
    }

    public ListView cellRenderer(ListCellRenderer<? super E> cellRenderer) {
        view.setCellRenderer(cellRenderer);
        return this;
    }

    public ListView dragEnabled(boolean b) {
        view.setDragEnabled(b);
        return this;
    }

    public ListView dropMode(DropMode dropMode) {
        view.setDropMode(dropMode);
        return this;
    }

    public ListView fixedCellHeight(int height) {
        view.setFixedCellHeight(height);
        return this;
    }

    public ListView fixedCellWidth(int width) {
        view.setFixedCellWidth(width);
        return this;
    }

    public ListView layoutOrientation(int layoutOrientation) {
        view.setLayoutOrientation(layoutOrientation);
        return this;
    }

    public ListView listData(E[] listData) {
        view.setListData(listData);
        return this;
    }

    public ListView listData(Vector<? extends E> listData) {
        view.setListData(listData);
        return this;
    }

    public ListView prototypeCellValue(E prototypeCellValue) {
        view.setPrototypeCellValue(prototypeCellValue);
        return this;
    }

    public ListView selectedIndex(int index) {
        view.setSelectedIndex(index);
        return this;
    }

    public ListView selectedIndices(int[] indices) {
        view.setSelectedIndices(indices);
        return this;
    }

    public ListView selectedValue(Object object, boolean shouldScroll) {
        view.setSelectedValue(object, shouldScroll);
        return this;
    }

    public ListView selectionBackground(Color selectionBackground) {
        view.setSelectionBackground(selectionBackground);
        return this;
    }

    public ListView selectionForeground(Color selectionForeground) {
        view.setSelectionForeground(selectionForeground);
        return this;
    }

    public ListView selectionInterval(int anchor, int lead) {
        view.setSelectionInterval(anchor, lead);
        return this;
    }

    public ListView selectionMode(int selectionMode) {
        view.setSelectionMode(selectionMode);
        return this;
    }

    public ListView selectionModel(ListSelectionModel selectionModel) {
        view.setSelectionModel(selectionModel);
        return this;
    }

    public ListView uI(ListUI ui) {
        view.setUI(ui);
        return this;
    }

    public ListView valueIsAdjusting(boolean b) {
        view.setValueIsAdjusting(b);
        return this;
    }

    public ListView visibleRowCount(int visibleRowCount) {
        view.setVisibleRowCount(visibleRowCount);
        return this;
    }
}
