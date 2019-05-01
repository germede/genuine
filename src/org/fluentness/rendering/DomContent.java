package org.fluentness.rendering;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DomContent implements CharSequence {

    private String content;

    public DomContent(CharSequence... renderables) {
        this.content = Arrays.stream(renderables).collect(Collectors.joining());
    }

    @Override
    public int length() {
        return content.length();
    }

    @Override
    public char charAt(int i) {
        return content.charAt(i);
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        return content.subSequence(i,i1);
    }

    @Override
    public String toString() {
        return content;
    }
}
