package org.fluentness.view.html;

import static org.fluentness.view.html.HtmlAttribute.SEPARATOR;

public abstract class Html implements CharSequence {

    protected final String tag;
    protected final StringBuilder attributes;
    protected final StringBuilder inner;

    public Html(String tag, CharSequence[] html) {
        this.tag = tag;
        attributes = new StringBuilder();
        inner = new StringBuilder();

        for (CharSequence item : html) {
            String render = item.toString();
            // if attribute
            if (render.startsWith(HtmlAttribute.SEPARATOR)) {
                render = render.substring(SEPARATOR.length());
                String[] split = render.split(SEPARATOR);
                attributes.append(' ').append(split[0]).append("=").append(split.length == 2 ? "\"" + split[1] + "\"" : "");
            } else {
                inner.append(render);
            }
        }
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int i) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return null;
    }
}
