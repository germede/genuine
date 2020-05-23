package org.fluentness.view.container;

import org.fluentness.view.component.Component;
import org.fluentness.view.component.HtmlComponent;

public class HtmlContainer extends HtmlComponent implements Container {

    private final StringBuilder inner = new StringBuilder();
    private HtmlComponent[] innerHtml;


    public HtmlContainer(String tag, HtmlComponent... inner) {
        super(tag);
        this.innerHtml = inner;
    }

    public HtmlContainer(String tag, CharSequence... inner) {
        super(tag);
        for (CharSequence item : inner) {
            this.inner.append(item);
        }
    }

    @Override
    public String toString() {
        if (innerHtml != null) {
            for (CharSequence item : innerHtml) {
                this.inner.append(item.toString());
            }
        }
        return "<" + tag + attributes + ">" + inner + "</" + tag + ">";
    }

    @Override
    public void add(Component component) {
        this.inner.append(component.toString());
    }
}
