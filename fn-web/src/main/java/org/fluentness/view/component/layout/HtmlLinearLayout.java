package org.fluentness.view.component.layout;

import org.fluentness.view.component.Component;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.HtmlContainer;

public class HtmlLinearLayout extends HtmlContainer implements LinearLayout {

    private final int orientation;

    public HtmlLinearLayout(int orientation, Component[] components) {
        super("div");
        withAttribute("class", "row");
        for (Component component : components) {
            if (component instanceof HtmlComponent) {
                HtmlComponent htmlComponent = (HtmlComponent) component;
                if (orientation == VERTICAL) {
                    htmlComponent.withAttribute("class", "col-12");
                }
                withInner(htmlComponent);
            }
        }
        this.orientation = orientation;
    }

    @Override
    public int getOrientation() {
        return orientation;
    }

    @Override
    public void setPadding(int top, int left, int bottom, int right) {
        withAttribute("style", String.format("padding: %d %d %d %d !important;", top, left, bottom, right));
    }

    @Override
    public void appendChild(Component child) {
        super.append((HtmlComponent) child);
    }
}
