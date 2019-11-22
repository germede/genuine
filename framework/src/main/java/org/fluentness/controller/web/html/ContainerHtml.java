package org.fluentness.controller.web.html;

import org.fluentness.controller.web.WebView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContainerHtml implements Html {

    protected String tag;
    protected List<Html> innerViews;

    public ContainerHtml(String tag, Html... inner) {
        this.tag = tag;
        this.innerViews = Arrays.asList(inner);
    }

    @Override
    public String render() {
        StringBuilder builder = new StringBuilder();
        builder.append("<");
        builder.append(tag);
        builder.append(
            innerViews.stream()
                .filter(Html -> Html instanceof Attribute)
                .map(WebView::render)
                .collect(Collectors.joining())
        );
        builder.append(">");
        if (innerViews != null) {
            builder.append(
                innerViews.stream()
                    .filter(Html -> !(Html instanceof Attribute))
                    .map(WebView::render)
                    .collect(Collectors.joining())
            );
        }
        builder.append("</").append(tag).append(">");
        return builder.toString();
    }
}
