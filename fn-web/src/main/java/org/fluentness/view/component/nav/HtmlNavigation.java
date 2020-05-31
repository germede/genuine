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

        HtmlContainer navLeft = new HtmlContainer("div").withAttribute("class", "nav-left")
            .withInner(new HtmlComponent("input").withAttribute("type", "checkbox"))
            .withInner(new HtmlContainer("span"), new HtmlContainer("span"), new HtmlContainer("span"));

        withInner(navLeft


            .withInner(brand = new HtmlContainer("a").withAttribute("href", "/"))
            .withInner(tabs = new HtmlContainer("div").withAttribute("class", "tabs"))
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
        );tabs.withInner(
            new HtmlContainer("a")
                .withAttribute("href", controller.getPath())
                .withInner(controller.getView().getTitle())
        );tabs.withInner(
            new HtmlContainer("a")
                .withAttribute("href", controller.getPath())
                .withInner(controller.getView().getTitle())
        );tabs.withInner(
            new HtmlContainer("a")
                .withAttribute("href", controller.getPath())
                .withInner(controller.getView().getTitle())
        );tabs.withInner(
            new HtmlContainer("a")
                .withAttribute("href", controller.getPath())
                .withInner(controller.getView().getTitle())
        );tabs.withInner(
            new HtmlContainer("a")
                .withAttribute("href", controller.getPath())
                .withInner(controller.getView().getTitle())
        );
    }

    public void setBrand(CharSequence title) {
        brand.withInner(title);
    }
}
