package com.sample.view;

import org.fluentness.view.Cacheable;
import org.fluentness.view.View;

import java.io.Serializable;

@Cacheable
public class DummyView implements View {

    @Override
    public Serializable render() {
        return "testasdf";
    }
}
