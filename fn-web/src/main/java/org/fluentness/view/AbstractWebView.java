package org.fluentness.view;

import org.fluentness.view.component.Component;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.HtmlContainer;
import org.fluentness.view.component.layout.HtmlLinearLayout;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.tab.HtmlTab;
import org.fluentness.view.component.tab.HtmlTabLayout;
import org.fluentness.view.component.tab.Tab;
import org.fluentness.view.component.tab.TabLayout;
import org.fluentness.view.component.table.HtmlTable;
import org.fluentness.view.component.table.Table;
import org.fluentness.view.component.text.Button;
import org.fluentness.view.component.text.HtmlButton;

public abstract class AbstractWebView extends AbstractView {

    private final HtmlContainer html;
    private String renderedHtml;

    public AbstractWebView(String title, HtmlComponent... headComponents) {
        this.html = new HtmlContainer("html")
            .withInner(new HtmlContainer("head")
                .withInner(new HtmlContainer("title").withInner(title))
                .withInner(new HtmlComponent("link")
                    .withAttribute("rel", "stylesheet")
                    .withAttribute("type", "text/css")
                    .withAttribute("href", "https://unpkg.com/chota@latest")
                )
                .withInner(headComponents)
                .withInner(new HtmlContainer("script")
                    .withAttribute("src", "/javascript")
                ))
            .withInner(new HtmlContainer("body").withInner((HtmlComponent) structure()));
    }

    public String getHtml() {
        if (renderedHtml == null) {
            renderedHtml = "<!DOCTYPE html>" + html.toString();
        }
        return renderedHtml;
    }

    @Override
    protected Button button(CharSequence text) {
        return new HtmlButton(text);
    }

    @Override
    protected LinearLayout linearLayout(int orientation, Component... components) {
        return new HtmlLinearLayout(orientation, components);
    }

    @Override
    protected Table table(CharSequence[] header, Object[]... rows) {
        return new HtmlTable(header, rows);
    }

    @Override
    protected TabLayout tabLayout(Tab... tabs) {
        return new HtmlTabLayout(tabs);
    }

    @Override
    protected Tab tab(CharSequence name, Component component) {
        return new HtmlTab(name, component);
    }
}
