package org.fluentness.view.component.layout;

import org.fluentness.view.component.Component;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.HtmlContainer;

public class HtmlNavigation extends HtmlContainer implements Navigation {

    public HtmlNavigation(Component[] components) {
        super("div");
        withAttribute("class", "row");
        for (Component component : components) {
            if (component instanceof HtmlComponent) {
                HtmlComponent htmlComponent = (HtmlComponent) component;
                htmlComponent.withAttribute("class", "col-12");
                withInner(htmlComponent);
            }
        }

    }

    @Override
    public void open() {

    }

    @Override
    public void close() {

    }
}
