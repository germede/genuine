package org.fluentness.controller.web.markup;

import org.fluentness.controller.web.WebView;

import java.util.Arrays;

public abstract class MarkupElement extends WebView {

    protected boolean isContainer;
    protected String tag;
    public MarkupAttributes attributes;
    protected WebView[] innerViews;
    protected String innerText;
    protected WebView[] predecessors;
    protected MarkupElement wrapper;
    protected WebView[] successors;

    protected MarkupElement(boolean isContainer) {
        this.isContainer = isContainer;
    }

    public MarkupElement precededBy(WebView... predecessors) {
        this.predecessors = predecessors;
        return this;
    }

    public MarkupElement wrappedBy(MarkupElement wrapper) {
        this.wrapper = wrapper;
        return this;
    }

    public MarkupElement followedBy(WebView... successors) {
        this.successors = successors;
        return this;
    }

    @Override
    public String render() {
        StringBuilder builder = new StringBuilder();

        // predecessors
        if (predecessors != null) {
            Arrays.stream(predecessors).forEach(predecessor -> builder.append(predecessor.render()));
        }

        // attributes
        String renderedAttributes = "";
        if (attributes != null) {
            renderedAttributes = attributes.render();
        }

        // tag
        builder.append("<").append(tag).append(renderedAttributes).append(">");
        if (isContainer) {
            if (innerViews != null) {
                for (WebView innerView : innerViews) {
                    builder.append(innerView.render());
                }
            }
            if (innerText != null) {
                builder.append(innerText);
            }
            builder.append("</").append(tag).append(">");
        }

        // successors
        if (successors != null) {
            Arrays.stream(successors).forEach(successor -> builder.append(successor.render()));
        }

        String rendered = builder.toString();
        // wrapper
        if (wrapper != null) {
            wrapper.innerText = rendered;
            rendered = wrapper.render();
        }

        return rendered;
    }

}
