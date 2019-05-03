package org.fluentness.view;

import org.fluentness.localization.Localizable;
import org.fluentness.rendering.ControlFlowFunctions;
import org.fluentness.rendering.HtmlAttribute;
import org.fluentness.rendering.HtmlElement;
import org.fluentness.rendering.HtmlHelpers;

public interface HtmlView extends View, HtmlElement, HtmlAttribute, HtmlHelpers, ControlFlowFunctions, Localizable {

}
