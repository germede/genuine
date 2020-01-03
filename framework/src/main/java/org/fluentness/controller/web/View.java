package org.fluentness.controller.web;

import org.fluentness.controller.web.template.WebTemplate;
import org.fluentness.controller.web.template.html.style.WebStyle;

public interface View {

    WebStyle getStyle();

    WebTemplate getTemplate(CharSequence toInclude);
}
