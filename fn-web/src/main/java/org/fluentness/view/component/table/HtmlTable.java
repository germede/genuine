package org.fluentness.view.component.table;

import org.fluentness.view.component.container.HtmlContainer;

import java.util.Arrays;

public class HtmlTable extends HtmlContainer implements Table{

    public HtmlTable(CharSequence[] header, Object[][] rows) {
        super("table");
        Arrays.stream(header).forEach(charSequence -> inner.append("<").append(charSequence));
    }
}
