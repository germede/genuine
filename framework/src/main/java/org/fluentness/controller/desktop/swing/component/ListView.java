package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;
import javax.swing.plaf.ListUI;
import java.awt.*;
import java.util.Vector;

public class ListView<E> extends AbstractComponentView<ListView, JList> {

    private JList<E> jList = new JList<>();

    public ListView(Class<E> listType) {

    }

    @Override
    public JList getView() {
        return jList;
    }

    public ListView cellRenderer(ListCellRenderer<? super E> cellRenderer) {
        jList.setCellRenderer(cellRenderer);
        return this;
    }

    public ListView dragEnabled(boolean b) {
        jList.setDragEnabled(b);
        return this;
    }

    public ListView dropMode(DropMode dropMode) {
        jList.setDropMode(dropMode);
        return this;
    }

    public ListView fixedCellHeight(int height) {
        jList.setFixedCellHeight(height);
        return this;
    }

    public ListView fixedCellWidth(int width) {
        jList.setFixedCellWidth(width);
        return this;
    }

    public ListView layoutOrientation(int layoutOrientation) {
        jList.setLayoutOrientation(layoutOrientation);
        return this;
    }

    public ListView listData(E[] listData) {
        jList.setListData(listData);
        return this;
    }

    public ListView listData(Vector<? extends E> listData) {
        jList.setListData(listData);
        return this;
    }

    public ListView model(ListModel<E> model) {
        jList.setModel(model);
        return this;
    }

    public ListView prototypeCellValue(E prototypeCellValue) {
        jList.setPrototypeCellValue(prototypeCellValue);
        return this;
    }

    public ListView selectedIndex(int index) {
        jList.setSelectedIndex(index);
        return this;
    }

    public ListView selectedIndices(int[] indices) {
        jList.setSelectedIndices(indices);
        return this;
    }

    public ListView selectedValue(Object object, boolean shouldScroll) {
        jList.setSelectedValue(object, shouldScroll);
        return this;
    }

    public ListView selectionBackground(Color selectionBackground) {
        jList.setSelectionBackground(selectionBackground);
        return this;
    }

    public ListView selectionForeground(Color selectionForeground) {
        jList.setSelectionForeground(selectionForeground);
        return this;
    }

    public ListView selectionInterval(int anchor, int lead) {
        jList.setSelectionInterval(anchor, lead);
        return this;
    }

    public ListView selectionMode(int selectionMode) {
        jList.setSelectionMode(selectionMode);
        return this;
    }

    public ListView selectionModel(ListSelectionModel selectionModel) {
        jList.setSelectionModel(selectionModel);
        return this;
    }

    public ListView uI(ListUI ui) {
        jList.setUI(ui);
        return this;
    }

    public ListView valueIsAdjusting(boolean b) {
        jList.setValueIsAdjusting(b);
        return this;
    }

    public ListView visibleRowCount(int visibleRowCount) {
        jList.setVisibleRowCount(visibleRowCount);
        return this;
    }
}
