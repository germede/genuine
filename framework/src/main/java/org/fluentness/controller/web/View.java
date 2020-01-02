package org.fluentness.controller.web;

import org.fluentness.controller.web.template.WebTemplate;
import org.fluentness.controller.web.template.html.style.WebStyle;

import static org.fluentness.controller.web.template.html.HtmlFactory.*;

public interface View {

    default WebStyle getStyle() {
        return null;
    }

    default WebTemplate getTemplate(WebTemplate toInclude) {
        return html(
            head(
                title("Fluentness rocks")
            ),
            body(
                toInclude
            )
        );
    }
}
