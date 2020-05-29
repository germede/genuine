package org.fluentness.view.component.tab;

import org.fluentness.view.component.Component;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.HtmlContainer;

public class HtmlTab extends HtmlContainer implements Tab {
    private final CharSequence name;

    public HtmlTab(CharSequence name, Component inner) {
        super("div");
        this.name = name;
        withInner((HtmlComponent) inner);
    }

    @Override
    public CharSequence getName() {
        return name;
    }
}
