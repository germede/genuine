package org.fluentness.rendering;

import java.util.Arrays;

public class MarkupElement implements Renderable {

    private String tag;
    private CharSequence[] renderables;
    private boolean isContainer;

    public MarkupElement(String tag, MarkupAttributes attributes) {
        this.tag = tag;
        this.renderables = new Renderable[]{attributes};
        this.isContainer = false;
    }

    public MarkupElement(String tag, CharSequence[] renderables) {
        this.tag = tag;
        this.renderables = renderables;
        this.isContainer = true;
    }


    @Override
    public String render() {
        StringBuilder html = new StringBuilder();

        // open
        html.append("<").append(tag);
        Arrays.stream(renderables)
                .filter(renderable -> renderable instanceof MarkupAttributes)
                .forEach(renderable->html.append(((MarkupAttributes) renderable).render()));
        html.append(">");

        // inner
        for (CharSequence renderable : renderables) {
            if ((renderable instanceof String)) {
                html.append(renderable);
            } else if (renderable instanceof Renderable && !(renderable instanceof MarkupAttributes)) {
                html.append(((Renderable) renderable).render());
            }
        }

        // close
        if (isContainer) {
            html.append("</").append(tag).append(">");
        }

        return html.toString();
    }

}
