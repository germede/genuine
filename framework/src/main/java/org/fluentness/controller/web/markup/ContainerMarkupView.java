package org.fluentness.controller.web.markup;

public class ContainerMarkupView extends AbstractMarkupView {

    public ContainerMarkupView(String tag, MarkupView... inner) {
        this.tag = tag;
        this.innerViews = inner;
    }

    public ContainerMarkupView(String tag, String inner) {
        this.tag = tag;
        this.innerText = inner;
    }
}
