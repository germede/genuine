package org.fluentness.view.component.table;

import android.content.Context;
import android.widget.TableLayout;

public class AndroidTable extends TableLayout implements Table {

    public AndroidTable(Context context) {
        super(context);
    }

    @Override
    public int getRowCount() {
        return getChildCount();
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getCell(int row, int column) {
        return null;
    }

    @Override
    public void setCell(int row, int column, Object value) {

    }

    @Override
    public void addRow(Object... values) {

    }

    @Override
    public void removeRow(int index) {

    }

    @Override
    public void addColumn(CharSequence columnName, Object... values) {

    }

    @Override
    public void removeColumn(int index) {

    }
}
