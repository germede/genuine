package com.sample.views;

import org.fluentness.mvc.View;

public class DummyView implements View {
    @Override
    public String render() {
        return "COndition is true";
    }
}
