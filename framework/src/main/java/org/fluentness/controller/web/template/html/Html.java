package org.fluentness.controller.web.template.html;

import org.fluentness.controller.web.template.WebTemplate;
import org.fluentness.service.translator.Translator;

import java.util.stream.IntStream;

public class Html implements CharSequence, WebTemplate {

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

    @Override
    public IntStream chars() {
        return null;
    }

    @Override
    public IntStream codePoints() {
        return null;
    }


    protected String tag;
    protected CharSequence[] html;

    public Html(String tag, CharSequence... html) {
        this.tag = tag;
        this.html = html;
    }

    @Override
    public String toString() {
        StringBuilder attributes = new StringBuilder();
        StringBuilder inner = new StringBuilder();
        for (CharSequence item : html) {
            String render = item.toString();
            if (render.startsWith(HtmlAttribute.PREFIX)) {
                attributes.append(" ").append(render.substring(3)).append("\"");
            } else {
                inner.append(Translator.translate(render));
            }
        }
        return "<" + tag + attributes + (inner.length() == 0 && !tag.equals("script") ? "/>" : (">" + inner + "</" + tag + ">"));
    }
}
