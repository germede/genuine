package org.fluentness.controller.desktop.swing;

import javax.swing.*;
import javax.swing.plaf.LabelUI;
import javax.swing.plaf.ListUI;
import java.awt.*;
import java.util.Vector;

public class JListBuilder<E> implements JComponentBuilder<JListBuilder, JList> {

    private JList<E> jList = new JList<>();

    public JListBuilder(Class<E> listType) {

    }

    @Override
    public JList getJComponent() {
        return jList;
    }

    public JListBuilder cellRenderer(ListCellRenderer<? super E> cellRenderer) {
        jList.setCellRenderer(cellRenderer);
        return this;
    }

    public JListBuilder dragEnabled(boolean b) {
        jList.setDragEnabled(b);
        return this;
    }

    public JListBuilder dropMode(DropMode dropMode) {
        jList.setDropMode(dropMode);
        return this;
    }

    public JListBuilder fixedCellHeight(int height) {
        jList.setFixedCellHeight(height);
        return this;
    }

    public JListBuilder fixedCellWidth(int width) {
        jList.setFixedCellWidth(width);
        return this;
    }

    public JListBuilder layoutOrientation(int layoutOrientation) {
        jList.setLayoutOrientation(layoutOrientation);
        return this;
    }

    public JListBuilder listData(E[] listData) {
        jList.setListData(listData);
        return this;
    }

    public JListBuilder listData(Vector<? extends E> listData) {
        jList.setListData(listData);
        return this;
    }

    public JListBuilder model(ListModel<E> model) {
        jList.setModel(model);
        return this;
    }

    public JListBuilder prototypeCellValue(E prototypeCellValue) {
        jList.setPrototypeCellValue(prototypeCellValue);
        return this;
    }

    public JListBuilder selectedIndex(int index) {
        jList.setSelectedIndex(index);
        return this;
    }

    public JListBuilder selectedIndices(int[] indices) {
        jList.setSelectedIndices(indices);
        return this;
    }

    public JListBuilder selectedValue(Object object, boolean shouldScroll) {
        jList.setSelectedValue(object, shouldScroll);
        return this;
    }

    public JListBuilder selectionBackground(Color selectionBackground) {
        jList.setSelectionBackground(selectionBackground);
        return this;
    }

    public JListBuilder selectionForeground(Color selectionForeground) {
        jList.setSelectionForeground(selectionForeground);
        return this;
    }

    public JListBuilder selectionInterval(int anchor, int lead) {
        jList.setSelectionInterval(anchor, lead);
        return this;
    }

    public JListBuilder selectionMode(int selectionMode) {
        jList.setSelectionMode(selectionMode);
        return this;
    }

    public JListBuilder selectionModel(ListSelectionModel selectionModel) {
        jList.setSelectionModel(selectionModel);
        return this;
    }

    public JListBuilder uI(ListUI ui) {
        jList.setUI(ui);
        return this;
    }

    public JListBuilder valueIsAdjusting(boolean b) {
        jList.setValueIsAdjusting(b);
        return this;
    }

    public JListBuilder visibleRowCount(int visibleRowCount) {
        jList.setVisibleRowCount(visibleRowCount);
        return this;
    }
}
