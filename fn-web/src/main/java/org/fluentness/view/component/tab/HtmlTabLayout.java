package org.fluentness.view.component.tab;

import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.HtmlContainer;

public class HtmlTabLayout extends HtmlContainer implements TabLayout<HtmlTab> {

    public HtmlTabLayout(Tab[] tabs) {
        super("div");
        withAttribute("class", "tab-layout");

        HtmlContainer nav = (HtmlContainer) new HtmlContainer("nav").withAttribute("class", "tabs");
        HtmlContainer figure = new HtmlContainer("figure");
        for (int i = 0; i < tabs.length; i++) {
            Tab tab = tabs[i];
            HtmlTab htmlTab = (HtmlTab) tab;
            String tabId = "tab" + (i + 1);

            withInner(new HtmlComponent("input").withAttribute("id", tabId).withAttribute("type", "radio").withAttribute("name", "tabs")); // tab trigger
            nav.withInner(new HtmlContainer("label").withInner(tab.getName()).withAttribute("for", tabId)); // tab name
            figure.withInner(htmlTab.withAttribute("class", tabId)); // tab content
        }
        withInner(nav);
        withInner(figure);
    }

    @Override
    public void setActive(HtmlTab tab) {

    }
}
