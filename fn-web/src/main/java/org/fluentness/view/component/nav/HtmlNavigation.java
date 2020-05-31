package org.fluentness.view.component.nav;

import org.fluentness.controller.view.AbstractWebViewController;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.HtmlContainer;

public class HtmlNavigation extends HtmlContainer implements Navigation<AbstractWebViewController> {

    private final HtmlContainer brand;
    private final HtmlContainer tabs;

    public HtmlNavigation() {
        super("nav");
        withAttribute("class", "nav");
        withInner(new HtmlContainer("div").withAttribute("class", "container")
            .withInner(new HtmlComponent("input").withAttribute("type", "checkbox").withAttribute("id", "burger"))
            .withInner(tabs = new HtmlContainer("div").withAttribute("class", "tabs")
                .withInner(brand = new HtmlContainer("a").withAttribute("href", "/").withAttribute("class", "brand"))
            )
            .withInner(new HtmlContainer("label").withAttribute("class", "burger").withAttribute("for", "burger")
                .withInner(new HtmlContainer("span"))
                .withInner(new HtmlContainer("span"))
                .withInner(new HtmlContainer("span"))
            )
        );
    }

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }

    @Override
    public void addSectionFor(AbstractWebViewController controller) {
        tabs.withInner(
            new HtmlContainer("a")
                .withAttribute("href", controller.getPath())
                .withInner(controller.getView().getTitle())
        );
        tabs.withInner(
            new HtmlContainer("a")
                .withAttribute("href", controller.getPath())
                .withInner(controller.getView().getTitle())
        );
    }

    public void setBrand(CharSequence title) {
        brand.withInner(title);
    }
}
