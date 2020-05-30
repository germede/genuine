package org.fluentness.view.component.layout;

import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.HtmlContainer;

public class HtmlTabLayout extends HtmlContainer implements TabLayout {

    public HtmlTabLayout(Tab[] tabs) {
        super("div");
        withAttribute("class", "tab-layout");

        HtmlContainer nav = (HtmlContainer) new HtmlContainer("nav").withAttribute("class", "tabs");
        HtmlContainer figure = new HtmlContainer("figure");
        for (int i = 0; i < tabs.length; i++) {
            Tab tab = tabs[i];
            String tabId = "tab" + (i + 1);

            // tab control
            HtmlComponent input = new HtmlComponent("input");
            withInner(input
                .withAttribute("id", tabId)
                .withAttribute("type", "radio")
                .withAttribute("name", "tabs"));
            if (i == 0) input.withAttribute("checked", null);
            // tab name
            nav.withInner(new HtmlContainer("label")
                .withInner(tab.getName())
                .withAttribute("for", tabId));
            // tab content
            figure.withInner(new HtmlContainer("div")
                .withInner((HtmlComponent) tab.getContent())
                .withAttribute("class", tabId));
        }
        withInner(nav);
        withInner(figure);
    }

    @Override
    public void setActive(int tabIndex) {

    }
}
