package org.fluentness.rendering;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MarkupElement implements Renderable {

    private String tag;
    private CharSequence[] renderables;
    private boolean isContainer;

    public MarkupElement(String tag, CharSequence[] renderables, boolean isContainer) {
        this.tag = tag;
        this.renderables = renderables;
        this.isContainer = isContainer;
    }


    @Override
    public String render() {
        StringBuilder html = new StringBuilder();

        // open
        html.append("<").append(tag);
        Arrays.stream(renderables)
                .filter(renderable -> renderable instanceof Attributes)
                .forEach(renderable->html.append(((Attributes) renderable).render()));
        html.append(">");

        // inner
        for (CharSequence renderable : renderables) {
            if ((renderable instanceof String)) {
                html.append(renderable);
            } else if (renderable instanceof Renderable && !(renderable instanceof Attributes)) {
                html.append(((Renderable) renderable).render());
            }
        }

        // close
        if (isContainer) {
            html.append("</").append(tag).append(">");
        }

        return html.toString();
    }

    static class Attributes implements Renderable {

        private final MarkupAttribute[] attributes;

        Attributes(MarkupAttribute[] attributes) {
            this.attributes = attributes;
        }

        @Override
        public String render() {
            return " " + Arrays.stream(attributes).collect(Collectors.joining(" "));
        }
    }
}
