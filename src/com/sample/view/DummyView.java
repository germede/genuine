package com.sample.view;

import org.fluentness.templating.HtmlTemplate;
import org.fluentness.templating.Template;
import org.fluentness.view.Cacheable;
import org.fluentness.view.View;

@Cacheable
public class DummyView implements View {

    @Override
    public Template getTemplate() {
        return new HtmlTemplate().append("testasdf");
    }
}
