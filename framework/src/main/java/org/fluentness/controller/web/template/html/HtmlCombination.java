package org.fluentness.controller.web.template.html;

import org.fluentness.controller.web.template.WebTemplate;

import java.util.stream.IntStream;

public class HtmlCombination implements WebTemplate {

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

    private final CharSequence html1;
    private final CharSequence html2;

    public HtmlCombination(CharSequence html1, CharSequence html2) {
        this.html1 = html1;
        this.html2 = html2;
    }

    @Override
    public String toString() {
        return html1.toString() + html2.toString();
    }
}
