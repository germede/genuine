package org.fluentness.service.authentication;

public enum AuthenticationType {
    BASIC("Basic ");

    private final String prefix;

    AuthenticationType(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String toString() {
        return prefix;
    }
}
