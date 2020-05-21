package org.fluentness.view.container;

import org.fluentness.view.component.Component;

public interface Container {

    void add(Component component);

    void add(Container container);

}
