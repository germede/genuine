package org.fluentness.view.component.table;

import org.fluentness.view.component.Component;

public interface Table extends Component {

    int getRowCount();

    int getColumnCount();

    Object getCell(int row, int column);

    void setCell(int row, int column, Object value);

    void addRow(Object... values);

    void removeRow(int index);

    void addColumn(CharSequence columnName, Object... values);

    void removeColumn(int index);

}
