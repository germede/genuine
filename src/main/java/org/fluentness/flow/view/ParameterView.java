package org.fluentness.flow.view;

public class ParameterView<T> extends View {

    private String parameter;

    ParameterView(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public String render() {
        return String.valueOf(View.retrieveParameterForCurrentThread(parameter));
    }
}
