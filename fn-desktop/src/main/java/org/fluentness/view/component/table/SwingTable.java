package org.fluentness.view.component.table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SwingTable extends JScrollPane implements Table {

    private final JTable table;
    private final DefaultTableModel model;

    public SwingTable(CharSequence[] header, Object[][] rows) {
        super();
        table = new JTable(new DefaultTableModel(rows, header));
        model = (DefaultTableModel) table.getModel();
        table.setAutoCreateRowSorter(true);
        setViewportView(table);
    }


    @Override
    public Object getCell(int row, int column) {
        return model.getValueAt(row, column);
    }

    @Override
    public void setCell(int row, int column, Object value) {
        model.setValueAt(value, row, column);
    }

    @Override
    public int getRowCount() {
        return model.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return model.getColumnCount();
    }

    @Override
    public void addRow(Object... values) {
        model.addRow(values);
    }

    @Override
    public void addColumn(CharSequence columnName, Object... values) {
        model.addColumn(columnName, values);
    }

    @Override
    public void removeRow(int index) {
        model.removeRow(index);
    }

    @Override
    public void removeColumn(int index) {
        table.removeColumn(table.getColumnModel().getColumn(index));
    }


}
