package org.fluentness.view.component.container;

import org.fluentness.controller.event.JavaScriptCommand;
import org.fluentness.view.component.HtmlComponent;

import java.util.LinkedList;
import java.util.List;

public class HtmlContainer extends HtmlComponent implements Container<HtmlComponent> {

    protected final StringBuilder inner = new StringBuilder();
    protected final List<HtmlComponent> innerHtml = new LinkedList<>();

    public HtmlContainer(String tag, String... attributes) {
        super(tag, attributes);
    }

    public HtmlContainer(String tag) {
        super(tag);
    }

    @Override
    public String toString() {
        if (innerHtml != null) {
            for (CharSequence item : innerHtml) {
                this.inner.append(item.toString());
            }
        }
        return super.toString() + inner + "</" + tag + ">";
    }

    @Override
    public void add(HtmlComponent component) {
        JavaScriptCommand.appendChild(id, component);
    }
}
