package com.sample.view;

import org.fluentness.view.Cacheable;
import org.fluentness.view.View;


@Cacheable
public class HeadView implements View.Html {

    @Override
    public CharSequence render() {
        return head(
//                title("the best site"),
//                meta(name("lang"),content("es")),
//                meta(charset("utf-8"))
        );
    }
}
