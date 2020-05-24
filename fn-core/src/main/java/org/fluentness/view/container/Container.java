package org.fluentness.view.container;

import org.fluentness.view.component.Component;

public interface Container<C extends Component> extends Component {

    void add(C component);

}
