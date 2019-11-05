package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;
import javax.swing.plaf.ListUI;
import java.awt.*;
import java.util.Vector;

public class JListView<E> implements JComponentView<JListView, JList> {

    private JList<E> jList = new JList<>();

    public JListView(Class<E> listType) {

    }

    @Override
    public JList getView() {
        return jList;
    }

    public JListView cellRenderer(ListCellRenderer<? super E> cellRenderer) {
        jList.setCellRenderer(cellRenderer);
        return this;
    }

    public JListView dragEnabled(boolean b) {
        jList.setDragEnabled(b);
        return this;
    }

    public JListView dropMode(DropMode dropMode) {
        jList.setDropMode(dropMode);
        return this;
    }

    public JListView fixedCellHeight(int height) {
        jList.setFixedCellHeight(height);
        return this;
    }

    public JListView fixedCellWidth(int width) {
        jList.setFixedCellWidth(width);
        return this;
    }

    public JListView layoutOrientation(int layoutOrientation) {
        jList.setLayoutOrientation(layoutOrientation);
        return this;
    }

    public JListView listData(E[] listData) {
        jList.setListData(listData);
        return this;
    }

    public JListView listData(Vector<? extends E> listData) {
        jList.setListData(listData);
        return this;
    }

    public JListView model(ListModel<E> model) {
        jList.setModel(model);
        return this;
    }

    public JListView prototypeCellValue(E prototypeCellValue) {
        jList.setPrototypeCellValue(prototypeCellValue);
        return this;
    }

    public JListView selectedIndex(int index) {
        jList.setSelectedIndex(index);
        return this;
    }

    public JListView selectedIndices(int[] indices) {
        jList.setSelectedIndices(indices);
        return this;
    }

    public JListView selectedValue(Object object, boolean shouldScroll) {
        jList.setSelectedValue(object, shouldScroll);
        return this;
    }

    public JListView selectionBackground(Color selectionBackground) {
        jList.setSelectionBackground(selectionBackground);
        return this;
    }

    public JListView selectionForeground(Color selectionForeground) {
        jList.setSelectionForeground(selectionForeground);
        return this;
    }

    public JListView selectionInterval(int anchor, int lead) {
        jList.setSelectionInterval(anchor, lead);
        return this;
    }

    public JListView selectionMode(int selectionMode) {
        jList.setSelectionMode(selectionMode);
        return this;
    }

    public JListView selectionModel(ListSelectionModel selectionModel) {
        jList.setSelectionModel(selectionModel);
        return this;
    }

    public JListView uI(ListUI ui) {
        jList.setUI(ui);
        return this;
    }

    public JListView valueIsAdjusting(boolean b) {
        jList.setValueIsAdjusting(b);
        return this;
    }

    public JListView visibleRowCount(int visibleRowCount) {
        jList.setVisibleRowCount(visibleRowCount);
        return this;
    }
}
