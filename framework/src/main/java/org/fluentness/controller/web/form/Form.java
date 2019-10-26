package org.fluentness.controller.web.form;

import org.fluentness.controller.web.WebView;
import org.fluentness.controller.web.markup.MarkupElement;
import org.fluentness.controller.web.markup.MarkupElementContainer;
import org.fluentness.service.server.HttpMethod;

public class Form extends MarkupElementContainer {

    Form(HttpMethod methodValue, String actionValue, Field[] fields) {
        super("form");
//        attributes = new MarkupAttributes(method + methodValue, action -> actionValue);
        innerViews = new WebView[fields.length];
        for (int i = 0; i < fields.length; i++) {
//            KeyValuePairLambda<Field> field = fields[i];
//            Field fieldInstance = field.getValue();
//            fieldInstance.attributes.add(name -> field.getKey());
//            innerViews[i] = fieldInstance;
        }
    }

    public Form precededBy(WebView... predecessors) {
        return (Form) super.precededBy(predecessors);
    }

    public Form wrappedBy(MarkupElement wrapper) {
        return (Form) super.wrappedBy(wrapper);
    }

    public Form followedBy(WebView... successors) {
        return (Form) super.followedBy(successors);
    }
}

