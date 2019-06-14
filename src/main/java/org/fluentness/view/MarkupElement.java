package org.fluentness.view;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class MarkupElement extends View {

    private boolean isContainer;
    String tag;
    Map<String,String> attributes;
    MarkupElement[] innerMarkupElements;
    String innerText;
    private MarkupElement[] predecessors;
    private MarkupElement wrapper;
    private MarkupElement[] successors;

    public MarkupElement(boolean isContainer) {
        this.isContainer = isContainer;
    }

    protected void addAttribute(String key, String value) {
        this.attributes.put(key, value);
    }

    public MarkupElement precededBy(MarkupElement... predecessors) {
        this.predecessors = predecessors;
        return this;
    }

    public MarkupElement wrappedBy(MarkupElement wrapper) {
        this.wrapper = wrapper;
        return this;
    }

    public MarkupElement followedBy(MarkupElement... successors) {
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
            renderedAttributes = attributes.entrySet().stream()
                .map(attribute -> " " + attribute.getKey() + (attribute.getValue() != null ? ("=\"" + attribute.getValue() + "\"") : ""))
                .collect(Collectors.joining());
        }

        // tag
        builder.append("<").append(tag).append(renderedAttributes).append(">");
        if (isContainer) {
            if (innerMarkupElements != null) {
                for (MarkupElement contentElement : innerMarkupElements) {
                    builder.append(contentElement.render());
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

        // wrapper
        if (wrapper != null) {
            wrapper.innerText = builder.toString();

            return wrapper.render();
        }

        return builder.toString();
    }
}
