package org.fluentness.view;

import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.HtmlContainer;
import org.fluentness.view.component.modal.HtmlModal;
import org.fluentness.view.component.layout.HtmlLinearLayout;
import org.fluentness.view.component.layout.HtmlTabLayout;
import org.fluentness.view.component.layout.TabLayout;
import org.fluentness.view.component.misc.HtmlSeparator;
import org.fluentness.view.component.navigation.HtmlNavigation;
import org.fluentness.view.component.navigation.Navigation;
import org.fluentness.view.component.table.HtmlTable;
import org.fluentness.view.component.text.Heading;
import org.fluentness.view.component.text.HtmlButton;
import org.fluentness.view.component.text.HtmlHeading;
import org.fluentness.view.component.text.HtmlText;
import org.fluentness.view.component.text.form.Button;

import java.util.Locale;

public abstract class WebView extends BaseView<
    HtmlButton,
    HtmlComponent,
    HtmlHeading,
    HtmlLinearLayout,
    HtmlModal,
    HtmlNavigation,
    HtmlSeparator,
    HtmlTabLayout,
    HtmlTable,
    HtmlText
    > {

    private final HtmlContainer html;
    private String renderedHtml;

    public static final Navigation navigation = new HtmlNavigation();

    public WebView() {
        this("");
    }

    public WebView(CharSequence title) {
        super(title);
        this.html = new HtmlContainer("html").withAttribute("lang", Locale.getDefault().getLanguage())
            .withInner(new HtmlContainer("head")
                .withInner(new HtmlContainer("title").withInner(this.title))
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
    protected HtmlLinearLayout linearLayout(HtmlComponent... components) {
        return new HtmlLinearLayout(components);
    }

    @Override
    protected HtmlTabLayout tabLayout(TabLayout.Tab... tabs) {
        return new HtmlTabLayout(tabs);
    }


    @Override
    protected HtmlSeparator separator() {
        return new HtmlSeparator();
    }

    @Override
    protected HtmlNavigation navigation() {
        return new HtmlNavigation();
    }

    @Override
    protected HtmlModal modal(HtmlComponent... components) {
        return new HtmlModal(components);
    }

    @Override
    protected HtmlButton button(Button.Type type, CharSequence text) {
        return new HtmlButton(type, text);
    }

    @Override
    protected HtmlHeading heading(Heading.Level level, CharSequence text) {
        return new HtmlHeading(level, text);
    }

    @Override
    protected HtmlText text(CharSequence text) {
        return new HtmlText(text);
    }


    @Override
    protected HtmlTable table(CharSequence[] header, Object[]... rows) {
        return new HtmlTable(header, rows);
    }

}
