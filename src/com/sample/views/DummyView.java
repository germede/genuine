package com.sample.views;

import org.fluencyframework.mvc.View;

public class DummyView implements View {
    @Override
    public String render() {
        return "COndition is true";
    }
}
