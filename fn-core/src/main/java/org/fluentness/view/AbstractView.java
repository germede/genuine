package org.fluentness.view;

import org.fluentness.view.component.Button;
import org.fluentness.view.component.Component;
import org.fluentness.view.container.Container;
import org.fluentness.view.container.LinearLayout;
import org.fluentness.view.template.Template;

public abstract class AbstractView implements View {

    protected final Template template;

    public AbstractView() {
        // pre-render template
        template = template();
        style();
    }

    @Override
    public final Template getTemplate() {
        return template;
    }

    protected abstract Template template();

    protected abstract void style();

    protected abstract Template template(String title, Container container);

    protected abstract LinearLayout linearLayout(Component... components);

    protected abstract Button button(String text);


}
