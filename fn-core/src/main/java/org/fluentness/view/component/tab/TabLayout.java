package org.fluentness.view.component.tab;

import org.fluentness.view.component.Component;

public interface TabLayout<T extends Tab> extends Component {

    void setActive(T tab);
}
