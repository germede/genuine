package org.fluentness.view;

import org.fluentness.view.component.Component;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.HtmlContainer;
import org.fluentness.view.component.layout.HtmlLinearLayout;
import org.fluentness.view.component.layout.HtmlTabLayout;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.layout.TabLayout;
import org.fluentness.view.component.nav.HtmlNavigation;
import org.fluentness.view.component.nav.Navigation;
import org.fluentness.view.component.table.HtmlTable;
import org.fluentness.view.component.table.Table;
import org.fluentness.view.component.text.Button;
import org.fluentness.view.component.text.HtmlButton;

import java.util.Locale;

public abstract class AbstractWebView extends AbstractView {

    private final HtmlContainer html;
    private String renderedHtml;

    public static final Navigation navigation = new HtmlNavigation();

    public AbstractWebView(CharSequence title, HtmlComponent... headComponents) {
        super(title);
        this.html = new HtmlContainer("html").withAttribute("lang", Locale.getDefault().getLanguage())
            .withInner(new HtmlContainer("head")
                .withInner(new HtmlContainer("title").withInner(title))
                .withInner(new HtmlComponent("link")
                    .withAttribute("rel", "stylesheet")
                    .withAttribute("type", "text/css")
                    .withAttribute("href", "/resources/css/main.css")
                )
                .withInner(headComponents)
                .withInner(new HtmlContainer("script")
                    .withAttribute("src", "/javaScript")
                ))
            .withInner(new HtmlContainer("body").withInner((HtmlComponent) structure()).withAttribute("class", "container"));
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
    protected LinearLayout linearLayout(Component... components) {
        return new HtmlLinearLayout(components);
    }

    @Override
    protected Table table(CharSequence[] header, Object[]... rows) {
        return new HtmlTable(header, rows);
    }

    @Override
    protected TabLayout tabLayout(TabLayout.Tab... tabs) {
        return new HtmlTabLayout(tabs);
    }

}
