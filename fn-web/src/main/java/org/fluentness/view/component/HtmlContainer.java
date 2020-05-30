package org.fluentness.view.component;

import org.fluentness.controller.event.JavaScriptCommand;

import java.util.LinkedList;
import java.util.List;

public class HtmlContainer extends HtmlComponent {

    private final StringBuilder inner = new StringBuilder();
    private final List<HtmlComponent> innerHtml = new LinkedList<>();

    public HtmlContainer(String tag) {
        super(tag);
    }

    public List<HtmlComponent> getInnerHtml() {
        return innerHtml;
    }

    public HtmlContainer withInner(HtmlComponent inner) {
        innerHtml.add(inner);
        inner.setParent(this);
        return this;
    }

    public HtmlContainer withInner(HtmlComponent[] inner) {
        for (HtmlComponent htmlComponent : inner) {
            innerHtml.add(htmlComponent);
            htmlComponent.setParent(this);
        }
        return this;
    }

    public HtmlContainer withInner(CharSequence inner) {
        this.inner.append(inner);
        return this;
    }

    @Override
    public String toString() {
        for (HtmlComponent item : innerHtml) {
            this.inner.append(item.toString());
        }
        return super.toString() + inner + "</" + tag + ">";
    }

    public void append(HtmlComponent child) {
        JavaScriptCommand.appendChild(getXpath(), child);
    }
}
