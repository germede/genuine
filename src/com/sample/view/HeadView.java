package com.sample.view;

import org.fluentness.templating.Template;
import org.fluentness.view.Cacheable;
import org.fluentness.view.View;
import org.fluentness.templating.HtmlTag;
import org.fluentness.templating.HtmlTemplate;

@Cacheable
public class HeadView implements View {

    @Override
    public Template getTemplate() {

        return new HtmlTemplate()
                .open(HtmlTag.head)
                .title("the best site")
                .meta().set("name", "lang").set("content", "es")
                .meta().set("charset", "utf-8")
                .includeJs("js/scripts.js")
                .includeCss("css/styles.css")
                .close(HtmlTag.head);
    }
}
