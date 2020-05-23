package org.fluentness.view.container;

import org.fluentness.view.component.Component;
import org.fluentness.view.component.HtmlComponent;

import static org.fluentness.view.component.HtmlAttribute.CLASS;

public class HtmlLinearLayout extends HtmlContainer implements LinearLayout {

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
    public void add(Component component) {

    }
}
