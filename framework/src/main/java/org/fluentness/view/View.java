package org.fluentness.view;

import org.fluentness.ApplicationComponent;

public interface View extends ApplicationComponent {

    Object render(Object... parameters);

}
