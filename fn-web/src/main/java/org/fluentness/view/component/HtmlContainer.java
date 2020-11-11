package org.fluentness.view.component;

import org.fluentness.controller.JavaScriptCommand;
import org.fluentness.service.translator.Translator;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    public HtmlContainer withInner(HtmlComponent... inner) {
        for (HtmlComponent htmlComponent : inner) withInner(htmlComponent);
        return this;
    }

    public HtmlContainer withInner(CharSequence inner) {
        this.inner.append(inner);
        return this;
    }

    @Override
    public HtmlContainer withAttribute(String key, Object value) {
        return (HtmlContainer) super.withAttribute(key, value);
    }

    @Override
    public HtmlContainer withAttribute(String key) {
        return (HtmlContainer) super.withAttribute(key);
    }

    @Override
    public String toString() {
        return super.toString().replace("/>", ">" +
            innerHtml.stream().map(HtmlComponent::toString).map(Translator::translate).collect(Collectors.joining()) +
            Translator.translate(inner.toString()) +
            "</" + tag + ">"
        );
    }

    public void append(CharSequence child) {
        JavaScriptCommand.appendChild(getXpath(), child);
    }

    public void append(HtmlComponent child) {
        JavaScriptCommand.appendChild(getXpath(), child.toString());
    }
}
