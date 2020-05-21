package org.fluentness.view.html;

import org.fluentness.view.component.Component;
import org.fluentness.view.container.Container;

public class HtmlRoot extends Html implements Container {

    public HtmlRoot(CharSequence[] html) {
        super("html", html);
    }

    @Override
    public String toString() {
        return "<!DOCTYPE html><" + tag + attributes + ">" + inner + "</" + tag + ">";
    }

    @Override
    public void add(Component component) {

    }
}
