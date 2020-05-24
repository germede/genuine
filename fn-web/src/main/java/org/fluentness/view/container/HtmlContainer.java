package org.fluentness.view.container;

import org.fluentness.controller.event.JavaScriptCommand;
import org.fluentness.view.component.HtmlComponent;

import java.util.Arrays;

public class HtmlContainer extends HtmlComponent implements Container<HtmlComponent> {

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

    public HtmlContainer(String tag, String... inner) {
        super(tag);
        Arrays.stream(inner).forEach(this::addAttribute);
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
