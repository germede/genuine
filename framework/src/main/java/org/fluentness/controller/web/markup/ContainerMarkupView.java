package org.fluentness.controller.web.markup;

import org.fluentness.controller.web.WebView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContainerMarkupView implements MarkupView {

    protected String tag;
    protected List<MarkupView> innerViews;

    public ContainerMarkupView(String tag, MarkupView... inner) {
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
                .filter(markupView -> markupView instanceof AttributeMarkupView)
                .map(WebView::render)
                .collect(Collectors.joining())
        );
        builder.append(">");
        if (innerViews != null) {
            builder.append(
                innerViews.stream()
                    .filter(markupView -> !(markupView instanceof AttributeMarkupView))
                    .map(WebView::render)
                    .collect(Collectors.joining())
            );
        }
        builder.append("</").append(tag).append(">");
        return builder.toString();
    }
}
