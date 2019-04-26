package org.fluentness.view;

public interface View {

    String render();

    default String translate() {
        return render();
    }
}
