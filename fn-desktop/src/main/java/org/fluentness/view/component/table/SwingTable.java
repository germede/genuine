package org.fluentness.view.component.table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SwingTable extends JTable implements Table {

    private final DefaultTableModel model;

    public SwingTable(CharSequence[] header, Object[][] rows) {
        super(new DefaultTableModel(rows, header));
        model = (DefaultTableModel) getModel();
    }



}
