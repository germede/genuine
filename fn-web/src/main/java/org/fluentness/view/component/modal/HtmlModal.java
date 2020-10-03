package org.fluentness.view.component.modal;

import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.HtmlContainer;

public class HtmlModal extends HtmlContainer implements Modal {

    public HtmlModal(HtmlComponent[] inner) {
        super("div");
        withAttribute("class", "modal");
        withInner(
            new HtmlContainer("div").withAttribute("class", "container")
                .withInner(new HtmlContainer("span").withAttribute("class","close-button").withInner("x"))
                .withInner(inner)
        );
    }

    @Override
    public void show() {
        toggleClass("show");
    }

    @Override
    public void hide() {
        toggleClass("show");
    }
}
