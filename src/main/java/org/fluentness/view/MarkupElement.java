package org.fluentness.view;

import org.fluentness.common.lambdas.NamedValue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class MarkupElement extends View {

    private boolean isContainer;
    String tag;
    List<NamedValue<String>> attributes;
    MarkupElement[] innerMarkupElements;
    String innerText;
    private MarkupElement[] predecessors;
    private MarkupElement wrapper;
    private MarkupElement[] successors;

    public MarkupElement(boolean isContainer) {
        this.isContainer = isContainer;
    }

    public MarkupElement addAttribute(NamedValue<String> attribute) {
        this.attributes.add(attribute);
        return this;
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
    public String toString() {
        StringBuilder builder = new StringBuilder();

        // predecessors
        if (predecessors != null) {
            Arrays.stream(predecessors).forEach(predecessor -> builder.append(predecessor.toString()));
        }

        // attributes
        String renderedAttributes = "";
        if (attributes != null) {
            renderedAttributes = attributes.stream()
                .map(attribute -> " " + attribute.name() + (attribute.value() != null ? ("=\"" + attribute.value() + "\"") : ""))
                .collect(Collectors.joining());
        }

        // tag
        builder.append("<").append(tag).append(renderedAttributes).append(">");
        if (isContainer) {
            if (innerMarkupElements != null) {
                for (MarkupElement contentElement : innerMarkupElements) {
                    builder.append(contentElement.toString());
                }
            }
            if (innerText != null) {
                builder.append(innerText);
            }
            builder.append("</").append(tag).append(">");
        }

        // successors
        if (successors != null) {
            Arrays.stream(successors).forEach(successor -> builder.append(successor.toString()));
        }

        // wrapper
        if (wrapper != null) {
            wrapper.innerText = builder.toString();
            return wrapper.toString();
        }

        return builder.toString();
    }
}
