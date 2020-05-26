package org.fluentness.view.component.table;

import org.fluentness.view.HtmlFactory;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.container.HtmlContainer;

import java.util.Arrays;

import static org.fluentness.view.HtmlFactory.*;

public class HtmlTable extends HtmlContainer implements Table {


    private final HtmlContainer thead;
    private final HtmlContainer tbody;

    public HtmlTable(CharSequence[] header, Object[][] rows) {
        super("table");

        thead = thead(
            Arrays.stream(header).map(HtmlFactory::th).toArray(CharSequence[]::new)
        );
        innerHtml.add(thead);

        HtmlComponent[] tbodyInnerHtml = new HtmlComponent[rows.length];
        for (int i = 0; i < rows.length; i++) {
            Object[] row = rows[i];
            tbodyInnerHtml[i] = tr(
                Arrays.stream(row).map(String::valueOf).map(HtmlFactory::td).toArray(CharSequence[]::new)
            );
        }
        tbody = tbody(tbodyInnerHtml);
        innerHtml.add(tbody);
    }

    @Override
    public int getRowCount() {
        return 0;
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
