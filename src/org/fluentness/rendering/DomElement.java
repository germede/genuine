package org.fluentness.rendering;

public class DomElement implements CharSequence {

    private StringBuilder html;

    public DomElement(String tag, CharSequence[] renderables, boolean isContainer) {
        this.html = new StringBuilder();

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
            if (!(renderable instanceof String) || !((String) renderable).startsWith("###")) {
                html.append(renderable.toString());
            }
        }

        // close
        if (isContainer) {
            html.append("</").append(tag).append(">");
        }
    }


    @Override
    public int length() {
        return html.length();
    }

    @Override
    public char charAt(int i) {
        return html.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return html.subSequence(i,i1);
    }

    @Override
    public String toString() {
        return html.toString();
    }
}
