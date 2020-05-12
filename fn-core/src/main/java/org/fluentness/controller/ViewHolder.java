package org.fluentness.controller;

import org.fluentness.Application;

public interface ViewHolder<V extends View> extends Application.Component {

    V render();

}
