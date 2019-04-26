package org.fluencyframework.exc;

public class MethodIsAbsentOrInaccessibleException extends Exception {

    private String className;
    private String methodName;

    public MethodIsAbsentOrInaccessibleException(String className, String methodName) {
        this.className = className;
        this.methodName = methodName;
    }

    @Override
    public String getMessage() {
        return "Method " + className + "->" + methodName + "() does not exist or is not accessible";
    }
}
