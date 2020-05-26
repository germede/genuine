package org.fluentness.view;

import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.container.HtmlContainer;
import org.fluentness.view.component.container.HtmlLinearLayout;
import org.fluentness.view.component.table.HtmlTable;
import org.fluentness.view.component.text.HtmlButton;

import static org.fluentness.view.HtmlFactory.*;
import static org.fluentness.view.component.HtmlComponent.Attribute.*;

public abstract class AbstractWebView extends AbstractView<
    HtmlComponent,
    HtmlContainer,
    HtmlButton,
    HtmlTable,
    HtmlLinearLayout
    > {

    private final HtmlContainer html;
    private String renderedHtml;

    public AbstractWebView(String title, HtmlComponent... headComponents) {
        HtmlComponent[] finalHeadComponents = new HtmlComponent[headComponents.length + 2];
        finalHeadComponents[0] = title(title);
        for (int i = 1, headComponentsLength = headComponents.length; i < headComponentsLength; i++) {
            finalHeadComponents[i] = headComponents[i - 1];
        }
        finalHeadComponents[finalHeadComponents.length - 2] = link(REL + "stylesheet", TYPE + "text/css", HREF + "https://unpkg.com/chota@latest");
        finalHeadComponents[finalHeadComponents.length - 1] = script(SRC + "/javaScript");

        this.html = new HtmlContainer("html",
            new HtmlContainer("head", finalHeadComponents),
            new HtmlContainer("body", new HtmlComponent[]{structure()})
        );
    }

    public String getHtml() {
        if (renderedHtml == null) {
            renderedHtml = "<!DOCTYPE html>" + html.toString();
        }
        return renderedHtml;
    }

    @Override
    protected HtmlButton button(CharSequence text) {
        return new HtmlButton(text);
    }

    @Override
    protected HtmlLinearLayout linearLayout(int orientation, HtmlComponent... components) {
        return new HtmlLinearLayout(orientation, components);
    }

    @Override
    protected HtmlTable table(CharSequence[] header, Object[]... rows) {
        return new HtmlTable(header, rows);
    }


}
