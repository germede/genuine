package org.fluentness.view.component.layout;

import org.fluentness.controller.Controller;
import org.fluentness.view.component.Component;

public interface Navigation<C extends Controller> extends Component {

    void open();

    void close();

    void addSectionFor(C controller);

}
