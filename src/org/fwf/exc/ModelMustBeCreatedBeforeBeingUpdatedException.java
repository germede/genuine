package org.fwf.exc;

public class ModelMustBeCreatedBeforeBeingUpdatedException extends Exception {
    private String className;

    public ModelMustBeCreatedBeforeBeingUpdatedException(String className) {

        this.className = className;
    }

    @Override
    public String getMessage() {
        return "Model " + className + " must be first created before being updated";
    }
}
