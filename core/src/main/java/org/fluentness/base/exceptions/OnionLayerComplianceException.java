package org.fluentness.base.exceptions;

public class OnionLayerComplianceException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        if (message != null) {
            return message;
        } else {
            return super.getMessage();
        }
    }

    public OnionLayerComplianceException(String stringToFormat, Object... parameters) {
        message = String.format(stringToFormat, parameters);
    }
}
