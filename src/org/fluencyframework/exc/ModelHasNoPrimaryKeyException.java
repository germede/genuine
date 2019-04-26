package org.fluencyframework.exc;

public class ModelHasNoPrimaryKeyException extends Exception {
    private String className;

    public ModelHasNoPrimaryKeyException(String className) {

        this.className = className;
    }

    @Override
    public String getMessage() {
        return "Model " + className + " has no primary key";
    }
}
