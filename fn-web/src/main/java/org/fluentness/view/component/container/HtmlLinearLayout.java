package org.fluentness.view.component.container;

import org.fluentness.view.component.HtmlComponent;

import static org.fluentness.view.component.HtmlComponent.Attribute.CLASS;
import static org.fluentness.view.component.HtmlComponent.Attribute.STYLE;

public class HtmlLinearLayout extends HtmlContainer implements LinearLayout<HtmlComponent> {

    private final int orientation;

    public HtmlLinearLayout(int orientation, HtmlComponent[] components) {
        super("div", components);
        addAttribute(CLASS + "row");
        if (orientation == VERTICAL) {
            for (HtmlComponent component : components) {
                component.addAttribute(CLASS + "col-12");
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
        addAttribute(STYLE + String.format("padding: %d %d %d %d !important;", top, left, bottom, right));
    }
}
