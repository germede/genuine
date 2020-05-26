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

    public HtmlContainer(String tag, CharSequence... html) {
        super(tag);
        for (CharSequence charSequence : html) {
            if (charSequence instanceof HtmlComponent) {
                // inner html component
                innerHtml.add((HtmlComponent) charSequence);
            } else if (charSequence instanceof String) {
                if (((String) charSequence).startsWith(Attribute.SEPARATOR)) {
                    // attribute
                    addAttribute((String) charSequence);
                } else {
                    // normal string, append it as child
                    this.inner.append(charSequence);
                }
            }
        }
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
