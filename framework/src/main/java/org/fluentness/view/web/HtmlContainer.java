package org.fluentness.view.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HtmlContainer implements WebView {

    protected String tag;
    protected List<WebView> innerViews;

    public HtmlContainer(String tag, WebView... inner) {
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
                .filter(WebView -> WebView instanceof HtmlAttribute)
                .map(WebView::render)
                .collect(Collectors.joining())
        );
        builder.append(">");
        if (innerViews != null) {
            builder.append(
                innerViews.stream()
                    .filter(WebView -> !(WebView instanceof HtmlAttribute))
                    .map(WebView::render)
                    .collect(Collectors.joining())
            );
        }
        builder.append("</").append(tag).append(">");
        return builder.toString();
    }
}
