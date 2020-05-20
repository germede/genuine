package org.fluentness.view;

import org.fluentness.Application;

public interface View<V extends Template> extends Application.Component {

    V getTemplate();

}
