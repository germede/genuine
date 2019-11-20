package org.fluentness.controller.web.markup;

import org.fluentness.controller.web.WebView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ContainerMarkupView implements MarkupView {

    private String tag;
    private MarkupView[] innerViews;

    public ContainerMarkupView(String tag, MarkupView... inner) {
        this.tag = tag;
        this.innerViews = inner;
    }

    public String getTag() {
        return tag;
    }

    public MarkupView[] getInnerViews() {
        return innerViews;
    }

    public MarkupView inner(MarkupView... inner) {
        innerViews = inner;
        return this;
    }

    @Override
    public String render() {
        StringBuilder builder = new StringBuilder();
        builder.append("<");
        builder.append(tag);
        builder.append(
            Arrays.stream(innerViews)
                .filter(markupView -> markupView instanceof AttributeMarkupView)
                .map(WebView::render)
                .collect(Collectors.joining())
        );
        builder.append(">");
        if (innerViews != null) {
            builder.append(Arrays.stream(innerViews)
                .filter(markupView -> !(markupView instanceof AttributeMarkupView))
                .map(WebView::render)
                .collect(Collectors.joining())
            );
        }
        builder.append("</").append(tag).append(">");
        return builder.toString();
    }
}
