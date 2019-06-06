package org.fluentness.renderable;

import java.util.Arrays;

public class MarkupElement implements Renderable {

    private String tag;
    protected MarkupAttributes attributes;
    protected CharSequence[] inner;
    protected boolean isContainer;

    private Renderable[] predecessors;
    private Renderable wrapper;
    private Renderable[] successors;

    public MarkupElement(String tag, MarkupAttributes attributes) {
        this.tag = tag;
        this.attributes = attributes;
        this.isContainer = false;
    }

    public MarkupElement(String tag, CharSequence... renderables) {
        this.tag = tag;
        this.attributes = (MarkupAttributes) Arrays.stream(renderables)
                .filter(renderable -> renderable instanceof MarkupAttributes)
                .findFirst().orElse(new MarkupAttributes());
        this.inner = Arrays.stream(renderables)
                .filter(renderable -> renderable instanceof MarkupElement || renderable instanceof String)
                .toArray(CharSequence[]::new);
        this.isContainer = true;
    }

    public MarkupElement precededBy(Renderable... predecessors) {
        this.predecessors = predecessors;
        return this;
    }

    public MarkupElement wrappedBy(Renderable wrapper) {
        this.wrapper = wrapper;
        return this;
    }

    public MarkupElement followedBy(Renderable... successors) {
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
                    builder.append(((Renderable) charSequence).render());
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
