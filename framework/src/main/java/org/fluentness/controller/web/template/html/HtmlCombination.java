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

    private final Html[] html;

    public HtmlCombination(Html[] html) {
        this.html = html;
    }

    @Override
    public String toString() {
        return String.join("",html);
    }
}
