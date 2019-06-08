package org.fluentness.view;

import java.util.Arrays;

public class MarkupElement implements View {

    private String tag;
    protected MarkupAttributes attributes;
    protected CharSequence[] inner;
    protected boolean isContainer;

    private View[] predecessors;
    private View wrapper;
    private View[] successors;

    public MarkupElement(String tag, MarkupAttributes attributes) {
        this.tag = tag;
        this.attributes = attributes;
        this.isContainer = false;
    }

    public MarkupElement(String tag, CharSequence... views) {
        this.tag = tag;
        this.attributes = (MarkupAttributes) Arrays.stream(views)
                .filter(view -> view instanceof MarkupAttributes)
                .findFirst().orElse(new MarkupAttributes());
        this.inner = Arrays.stream(views)
                .filter(view -> view instanceof MarkupElement || view instanceof String)
                .toArray(CharSequence[]::new);
        this.isContainer = true;
    }

    public MarkupElement precededBy(View... predecessors) {
        this.predecessors = predecessors;
        return this;
    }

    public MarkupElement wrappedBy(View wrapper) {
        this.wrapper = wrapper;
        return this;
    }

    public MarkupElement followedBy(View... successors) {
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

        // tag
        builder.append("<").append(tag).append(attributes.render()).append(">");
        if (isContainer) {
            for (CharSequence charSequence : inner) {
                if (charSequence instanceof MarkupElement) {
                    builder.append(((View) charSequence).render());
                } else {
                    builder.append(charSequence);
                }
            }
            builder.append("</").append(tag).append(">");
        }

        // successors
        if (successors != null) {
            Arrays.stream(successors).forEach(successor -> builder.append(successor.render()));
        }

        // wrapper
        if (wrapper instanceof MarkupElement) {
            ((MarkupElement) wrapper).inner = new CharSequence[]{builder.toString()};
            return wrapper.render();
        }

        return builder.toString();
    }

    @Override
    public String toString() {
        return render();
    }
}
