package com.sample.view;

import org.fluentness.view.Cacheable;
import org.fluentness.view.View;

@Cacheable
public class DummyView implements View {

    @Override
    public CharSequence render() {
        return "";
    }
}
