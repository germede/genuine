package org.fluentness.view.component.table;

import org.fluentness.view.component.HtmlContainer;

import java.util.Arrays;

public class HtmlTable extends HtmlContainer implements Table {


    private final HtmlContainer thead;
    private final HtmlContainer tbody;

    public HtmlTable(CharSequence[] header, Object[][] rows) {
        super("table");

        HtmlContainer headTr = new HtmlContainer("tr");
        thead = new HtmlContainer("thead").withInner(headTr);
        tbody = new HtmlContainer("tbody");

        Arrays.stream(header).forEach(item -> headTr.withInner(new HtmlContainer("th").withInner(item)));
        for (Object[] row : rows) {
            HtmlContainer tr = new HtmlContainer("tr");
            for (Object cell : row) {
                tr.withInner(new HtmlContainer("td").withInner(String.valueOf(cell)));
            }
            tbody.withInner(tr).setParent(tbody);
        }
        withInner(thead);
        withInner(tbody);
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
