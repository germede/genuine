package org.fluentness.service.configuration;

public enum Environment {
    DEV,
    TEST,
    STAGE,
    PROD;

    @Override
    public String toString() {
        return this.equals(DEV) ? "" : "_" + super.toString();
    }
}
