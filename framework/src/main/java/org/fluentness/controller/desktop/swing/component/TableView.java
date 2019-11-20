package org.fluentness.controller.desktop.swing.component;

import javax.swing.*;
import javax.swing.plaf.TableUI;
import javax.swing.table.*;
import java.awt.*;

public class TableView extends AbstractComponentView<TableView, JTable> {


    public TableView(String[] header, Object[]... rows) {
        super(new JTable(rows, header));
    }

    public TableView autoCreateRowSorter(boolean autoCreateRowSorter) {
        view.setAutoCreateRowSorter(autoCreateRowSorter);
        return this;
    }

    public TableView autoResizeMode(int mode) {
        view.setAutoResizeMode(mode);
        return this;
    }

    public TableView cellEditor(TableCellEditor anEditor) {
        view.setCellEditor(anEditor);
        return this;
    }

    public TableView cellSelectionEnabled(boolean cellSelectionEnabled) {
        view.setCellSelectionEnabled(cellSelectionEnabled);
        return this;
    }

    public TableView columnModel(TableColumnModel columnModel) {
        view.setColumnModel(columnModel);
        return this;
    }

    public TableView columnSelectionAllowed(boolean columnSelectionAllowed) {
        view.setColumnSelectionAllowed(columnSelectionAllowed);
        return this;
    }

    public TableView columnSelectionInterval(int index0, int index1) {
        view.setColumnSelectionInterval(index0, index1);
        return this;
    }

    public TableView defaultEditor(Class<?> columnClass, TableCellEditor editor) {
        view.setDefaultEditor(columnClass, editor);
        return this;
    }

    public TableView defaultRenderer(Class<?> columnClass, TableCellRenderer renderer) {
        view.setDefaultRenderer(columnClass, renderer);
        return this;
    }

    public TableView dragEnabled(boolean b) {
        view.setDragEnabled(b);
        return this;
    }

    public TableView dropMode(DropMode dropMode) {
        view.setDropMode(dropMode);
        return this;
    }

    public TableView editingColumn(int aColumn) {
        view.setEditingColumn(aColumn);
        return this;
    }

    public TableView editingRow(int aRow) {
        view.setEditingRow(aRow);
        return this;
    }

    public TableView fillsViewportHeight(boolean fillsViewportHeight) {
        view.setFillsViewportHeight(fillsViewportHeight);
        return this;
    }

    public TableView gridColor(Color gridColor) {
        view.setGridColor(gridColor);
        return this;
    }

    public TableView intercellSpacing(int x, int y) {
        view.setIntercellSpacing(new Dimension(x, y));
        return this;
    }

    public TableView preferredScrollableViewportSize(Dimension size) {
        view.setPreferredScrollableViewportSize(size);
        return this;
    }

    public TableView rowHeight(int rowHeight) {
        view.setRowHeight(rowHeight);
        return this;
    }

    public TableView rowHeight(int row, int rowHeight) {
        view.setRowHeight(row, rowHeight);
        return this;
    }

    public TableView rowMargin(int rowMargin) {
        view.setRowMargin(rowMargin);
        return this;
    }

    public TableView rowSelectionAllowed(boolean rowSelectionAllowed) {
        view.setRowSelectionAllowed(rowSelectionAllowed);
        return this;
    }

    public TableView rowSelectionInterval(int index0, int index1) {
        view.setRowSelectionInterval(index0, index1);
        return this;
    }

    public TableView rowSorter(RowSorter<? extends TableModel> sorter) {
        view.setRowSorter(sorter);
        return this;
    }

    public TableView selectionBackground(Color selectionBackground) {
        view.setSelectionBackground(selectionBackground);
        return this;
    }

    public TableView selectionForeground(Color selectionForeground) {
        view.setSelectionForeground(selectionForeground);
        return this;
    }

    public TableView selectionMode(int selectionMode) {
        view.setSelectionMode(selectionMode);
        return this;
    }

    public TableView showGrid(boolean showGrid) {
        view.setShowGrid(showGrid);
        return this;
    }

    public TableView showHorizontalLines(boolean showHorizontalLines) {
        view.setShowHorizontalLines(showHorizontalLines);
        return this;
    }

    public TableView showVerticalLines(boolean showVerticalLines) {
        view.setShowVerticalLines(showVerticalLines);
        return this;
    }

    public TableView surrendersFocusOnKeystroke(boolean surrendersFocusOnKeystroke) {
        view.setSurrendersFocusOnKeystroke(surrendersFocusOnKeystroke);
        return this;
    }

    public TableView uI(TableUI ui) {
        view.setUI(ui);
        return this;
    }

    public TableView updateSelectionOnSort(boolean update) {
        view.setUpdateSelectionOnSort(update);
        return this;
    }

}
