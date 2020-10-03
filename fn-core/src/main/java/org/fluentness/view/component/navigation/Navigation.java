package org.fluentness.view.component.navigation;

import org.fluentness.controller.Controller;
import org.fluentness.view.component.Component;

public interface Navigation<C extends Controller> extends Component {

    void open();

    void close();

    void addItem(C controller);

}
