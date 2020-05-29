package org.fluentness.view.component.layout;

import org.fluentness.view.component.Component;

public interface Layout<C> extends Component {

    void add(C child);

}
