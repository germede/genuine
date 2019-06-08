package org.fluentness.view;

import org.fluentness.FnAtoz;

public class View {

    public String render() {
        ViewProvider viewProvider = FnAtoz.getViewProvider();
        String viewName = viewProvider.getNameFor(this);
        if (viewProvider.isAnnotationPresent(viewName, ViewProvider.Template.class)) {
            View template = viewProvider.get(
                ((ViewProvider.Template) viewProvider.getAnnotation(viewName, ViewProvider.Template.class)).value()
            );
            return template.toString().replace("###PLACEHOLDER###", toString());
        }
        return toString();
    }

    View injectAttribute(String name, Object value) {
        // TODO
        return this;
    }


}
