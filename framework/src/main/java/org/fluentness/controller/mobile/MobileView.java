package org.fluentness.controller.mobile;

import org.fluentness.controller.View;
import org.fluentness.controller.mobile.template.MobileTemplate;

public interface MobileView extends View {

    MobileTemplate getTemplate();
}
