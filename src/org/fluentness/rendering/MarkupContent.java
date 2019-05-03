package org.fluentness.rendering;

import java.util.Arrays;

public class MarkupContent implements Renderable {

    private Renderable[] renderables;

    public MarkupContent(Renderable... renderables) {
        this.renderables = renderables;
    }

    @Override
    public String render() {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(renderables).forEach(renderable -> builder.append(renderable.render()));
        return builder.toString();
    }
}
