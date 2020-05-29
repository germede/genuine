package org.fluentness.view.component;

import org.fluentness.controller.event.JavaScriptCommand;
import org.fluentness.view.component.layout.Layout;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HtmlContainer extends HtmlComponent implements Layout<HtmlComponent> {

    private final StringBuilder inner = new StringBuilder();
    private final List<HtmlComponent> innerHtml = new LinkedList<>();

    public HtmlContainer(String tag) {
        super(tag);
    }

    public HtmlContainer withInner(HtmlComponent inner) {
        innerHtml.add(inner);
        return this;
    }

    public HtmlContainer withInner(HtmlComponent[] inner) {
        innerHtml.addAll(Arrays.asList(inner));
        return this;
    }

    public HtmlContainer withInner(CharSequence inner) {
        this.inner.append(inner);
        return this;
    }

    @Override
    public String toString() {
        if (innerHtml != null) {
            for (HtmlComponent item : innerHtml) {
                this.inner.append(item.toString());
            }
        }
        return super.toString() + inner + "</" + tag + ">";
    }

    @Override
    public void add(HtmlComponent child) {
        JavaScriptCommand.appendChild(id, child);
    }
}
