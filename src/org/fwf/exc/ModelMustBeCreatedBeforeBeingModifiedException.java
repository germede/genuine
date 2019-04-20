package org.fwf.exc;

public class ModelMustBeCreatedBeforeBeingModifiedException extends Exception {
    private String className;

    public ModelMustBeCreatedBeforeBeingModifiedException(String className) {

        this.className = className;
    }

    @Override
    public String getMessage() {
        return "Model " + className + " must be first created before being modified";
    }
}
