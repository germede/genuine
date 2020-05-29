package org.fluentness.view.component.tab;

import org.fluentness.view.component.HtmlContainer;

public class HtmlTabLayout extends HtmlContainer implements TabLayout<HtmlTab> {

    public HtmlTabLayout(Tab[] tabs) {
        super("div");
        HtmlContainer nav = (HtmlContainer) new HtmlContainer("nav").withAttribute("class", "tabs is-full");
        HtmlContainer div = new HtmlContainer("div");
        for (Tab tab : tabs) {
            HtmlTab htmlTab = (HtmlTab) tab;
            nav.withInner(new HtmlContainer("a").withInner(tab.getName()).withAttribute("for", String.valueOf(htmlTab.getId())));
            div.withInner(htmlTab);
        }
        withInner(nav);
        withInner(div);
    }

    @Override
    public void setActive(HtmlTab tab) {

    }
}
