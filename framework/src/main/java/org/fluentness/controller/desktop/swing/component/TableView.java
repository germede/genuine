package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;
import javax.swing.plaf.TableUI;
import javax.swing.table.*;
import java.awt.*;

public class TableView extends AbstractComponentView<TableView, JScrollPane> {

    private final JTable jTable;
    private final JScrollPane jScrollPane;

    public TableView(String[] header, Object[]... rows) {
        jTable = new JTable(rows, header);
        jScrollPane = new JScrollPane(jTable);
    }

    @Override
    public JScrollPane getSwingView() {
        return jScrollPane;
    }


    public TableView autoCreateRowSorter(boolean autoCreateRowSorter) {
        jTable.setAutoCreateRowSorter(autoCreateRowSorter);
        return this;
    }

    public TableView autoResizeMode(int mode) {
        jTable.setAutoResizeMode(mode);
        return this;
    }

    public TableView cellEditor(TableCellEditor anEditor) {
        jTable.setCellEditor(anEditor);
        return this;
    }

    public TableView cellSelectionEnabled(boolean cellSelectionEnabled) {
        jTable.setCellSelectionEnabled(cellSelectionEnabled);
        return this;
    }

    public TableView columnModel(TableColumnModel columnModel) {
        jTable.setColumnModel(columnModel);
        return this;
    }

    public TableView columnSelectionAllowed(boolean columnSelectionAllowed) {
        jTable.setColumnSelectionAllowed(columnSelectionAllowed);
        return this;
    }

    public TableView columnSelectionInterval(int index0, int index1) {
        jTable.setColumnSelectionInterval(index0, index1);
        return this;
    }

    public TableView defaultEditor(Class<?> columnClass, TableCellEditor editor) {
        jTable.setDefaultEditor(columnClass, editor);
        return this;
    }

    public TableView defaultRenderer(Class<?> columnClass, TableCellRenderer renderer) {
        jTable.setDefaultRenderer(columnClass, renderer);
        return this;
    }

    public TableView dragEnabled(boolean b) {
        jTable.setDragEnabled(b);
        return this;
    }

    public TableView dropMode(DropMode dropMode) {
        jTable.setDropMode(dropMode);
        return this;
    }

    public TableView editingColumn(int aColumn) {
        jTable.setEditingColumn(aColumn);
        return this;
    }

    public TableView editingRow(int aRow) {
        jTable.setEditingRow(aRow);
        return this;
    }

    public TableView fillsViewportHeight(boolean fillsViewportHeight) {
        jTable.setFillsViewportHeight(fillsViewportHeight);
        return this;
    }

    public TableView gridColor(Color gridColor) {
        jTable.setGridColor(gridColor);
        return this;
    }

    public TableView intercellSpacing(int x, int y) {
        jTable.setIntercellSpacing(new Dimension(x, y));
        return this;
    }

    public TableView preferredScrollableViewportSize(Dimension size) {
        jTable.setPreferredScrollableViewportSize(size);
        return this;
    }

    public TableView rowHeight(int rowHeight) {
        jTable.setRowHeight(rowHeight);
        return this;
    }

    public TableView rowHeight(int row, int rowHeight) {
        jTable.setRowHeight(row, rowHeight);
        return this;
    }

    public TableView rowMargin(int rowMargin) {
        jTable.setRowMargin(rowMargin);
        return this;
    }

    public TableView rowSelectionAllowed(boolean rowSelectionAllowed) {
        jTable.setRowSelectionAllowed(rowSelectionAllowed);
        return this;
    }

    public TableView rowSelectionInterval(int index0, int index1) {
        jTable.setRowSelectionInterval(index0, index1);
        return this;
    }

    public TableView rowSorter(RowSorter<? extends TableModel> sorter) {
        jTable.setRowSorter(sorter);
        return this;
    }

    public TableView selectionBackground(Color selectionBackground) {
        jTable.setSelectionBackground(selectionBackground);
        return this;
    }

    public TableView selectionForeground(Color selectionForeground) {
        jTable.setSelectionForeground(selectionForeground);
        return this;
    }

    public TableView selectionMode(int selectionMode) {
        jTable.setSelectionMode(selectionMode);
        return this;
    }

    public TableView showGrid(boolean showGrid) {
        jTable.setShowGrid(showGrid);
        return this;
    }

    public TableView showHorizontalLines(boolean showHorizontalLines) {
        jTable.setShowHorizontalLines(showHorizontalLines);
        return this;
    }

    public TableView showVerticalLines(boolean showVerticalLines) {
        jTable.setShowVerticalLines(showVerticalLines);
        return this;
    }

    public TableView surrendersFocusOnKeystroke(boolean surrendersFocusOnKeystroke) {
        jTable.setSurrendersFocusOnKeystroke(surrendersFocusOnKeystroke);
        return this;
    }

    public TableView uI(TableUI ui) {
        jTable.setUI(ui);
        return this;
    }

    public TableView updateSelectionOnSort(boolean update) {
        jTable.setUpdateSelectionOnSort(update);
        return this;
    }

}
