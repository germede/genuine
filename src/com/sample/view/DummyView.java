package com.sample.view;

import org.fwf.mvc.View;

public class DummyView implements View {
    @Override
    public String render() {
        return "COndition is true";
    }
}
