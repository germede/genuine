package org.fluentness.base.exceptions;

public class ProviderException extends Exception {
    private String message;

    @Override
    public String getMessage() {
        if (message != null) {
            return message;
        } else {
            return super.getMessage();
        }
    }

    public ProviderException(String stringToFormat, Object... parameters) {
        message = String.format(stringToFormat, parameters);
    }
}
