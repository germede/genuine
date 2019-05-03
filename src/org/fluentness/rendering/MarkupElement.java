package org.fluentness.rendering;

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
        html.append("<").append(tag).append(">");

        // append attributes
        for (CharSequence renderable : renderables) {
            if (renderable instanceof String && ((String) renderable).startsWith("###")) {
                String[] keyValue = renderable.toString().replace("###", "").split("=");
                String attribute = keyValue.length > 1 ?
                        " " + keyValue[0] + "=\"" + keyValue[1] + "\">" :
                        " " + keyValue[0];
                html.replace(html.length() - 1, html.length(), attribute);
            }
        }

        // append inner
        for (CharSequence renderable : renderables) {
            if ((renderable instanceof String) && !((String) renderable).startsWith("###")) {
                html.append(renderable);
            }
        }

        // append renderables
        for (CharSequence renderable : renderables) {
            if (renderable instanceof Renderable) {
                html.append(((Renderable)renderable).render());
            }
        }

        // close
        if (isContainer) {
            html.append("</").append(tag).append(">");
        }

        return html.toString();
    }
}
