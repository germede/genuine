package org.fluentness.controller.web.template.html;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Html implements CharSequence {

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
    protected List<CharSequence> html;

    public Html(String tag, CharSequence... html) {
        this.tag = tag;
        this.html = Arrays.asList(html);
    }

    @Override
    public String toString() {
        StringBuilder attributes = new StringBuilder();
        StringBuilder inner = new StringBuilder();
        for (CharSequence item : html) {
            String render = item.toString();
            if (render.startsWith("###")) {
                attributes.append(render.substring(3).concat("\""));
            } else {
                inner.append(item);
            }
        }
        return "<" + tag + String.join(attributes) + (inner.length() == 0 ? "/>" : ">" + inner + "</" + tag + ">");
    }

    public Html add(String attribute) {
        html.add(attribute);
        return this;
    }
}
