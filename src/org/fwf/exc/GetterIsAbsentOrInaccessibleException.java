package org.fwf.exc;

public class GetterIsAbsentOrInaccessibleException extends Throwable {

    private String fieldName;

    public GetterIsAbsentOrInaccessibleException(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
