package org.fluencyframework.exc;

public class ModelHasNoMappedTableException extends Exception {
    private String className;

    public ModelHasNoMappedTableException(String className) {

        this.className = className;
    }

    @Override
    public String getMessage() {
        return "Model " + className + " has no mapped table";
    }
}
