package org.fluentness.view.component.form;

import org.fluentness.view.component.Component;

public interface Field extends Component {

    enum Type {
        TEXT,
        PASSWORD,
        URL,
        EMAIL,
        PHONE,
        NUMBER,
        DISABLED,
    }

}
