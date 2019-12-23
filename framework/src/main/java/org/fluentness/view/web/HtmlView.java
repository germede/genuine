package org.fluentness.view.web;

import java.util.stream.IntStream;

public interface HtmlView extends Platform, CharSequence {

    @Override
    default int length() {
        return 0;
    }

    @Override
    default char charAt(int i) {
        return 0;
    }

    @Override
    default CharSequence subSequence(int i, int i1) {
        return null;
    }

    @Override
    default IntStream chars() {
        return null;
    }

    @Override
    default IntStream codePoints() {
        return null;
    }

}
