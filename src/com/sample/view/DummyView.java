package com.sample.view;

import org.fluentworkflow.mvc.View;

public class DummyView implements View {
    @Override
    public String render() {
        return "COndition is true";
    }
}
