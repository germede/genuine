package org.fluentness.view;

import org.fluentness.view.component.AbstractComponentView;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.HtmlContainer;
import org.fluentness.view.component.text.form.Button;
import org.fluentness.view.component.layout.HtmlLinearLayout;
import org.fluentness.view.component.layout.HtmlTabLayout;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.layout.TabLayout;
import org.fluentness.view.component.misc.HtmlSeparator;
import org.fluentness.view.component.misc.Separator;
import org.fluentness.view.component.navigation.HtmlNavigation;
import org.fluentness.view.component.navigation.Navigation;
import org.fluentness.view.component.table.HtmlTable;
import org.fluentness.view.component.table.Table;
import org.fluentness.view.component.text.*;

import java.util.Locale;

public abstract class AbstractWebView extends AbstractComponentView {

    private final HtmlContainer html;
    private String renderedHtml;

    public static final Navigation navigation = new HtmlNavigation();

    public AbstractWebView(CharSequence title) {
        super(title);
        this.html = new HtmlContainer("html").withAttribute("lang", Locale.getDefault().getLanguage())
            .withInner(new HtmlContainer("head")
                .withInner(new HtmlContainer("title").withInner(title))
                .withInner(new HtmlComponent("link")
                    .withAttribute("rel", "stylesheet")
                    .withAttribute("type", "text/css")
                    .withAttribute("href", "/resources/css/main.css")
                )
                .withInner()
                .withInner(new HtmlContainer("script").withAttribute("src", "/javaScript"))
            )
            .withInner(new HtmlContainer("body")
                .withInner((HtmlComponent) navigation)
                .withInner(new HtmlContainer("div").withAttribute("class", "container")
                    .withInner((HtmlComponent) structure())
                )
            );
    }

    public String getHtml() {
        if (renderedHtml == null) {
            renderedHtml = "<!DOCTYPE html>" + html.toString();
        }
        return renderedHtml;
    }


    @Override
    protected LinearLayout linearLayout(Component... components) {
        return new HtmlLinearLayout(components);
    }

    @Override
    protected TabLayout tabLayout(TabLayout.Tab... tabs) {
        return new HtmlTabLayout(tabs);
    }


    @Override
    protected Separator separator() {
        return new HtmlSeparator();
    }

    @Override
    protected Navigation navigation() {
        return new HtmlNavigation();
    }


    @Override
    protected Button button(Button.Type type, CharSequence text) {
        return new HtmlButton(type, text);
    }

    @Override
    protected Heading heading(Heading.Level level, CharSequence text) {
        return new HtmlHeading(level, text);
    }

    @Override
    protected Text text(CharSequence text) {
        return new HtmlText(text);
    }


    @Override
    protected Table table(CharSequence[] header, Object[]... rows) {
        return new HtmlTable(header, rows);
    }

}
