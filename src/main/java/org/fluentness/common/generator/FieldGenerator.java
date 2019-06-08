package org.fluentness.common.generator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class FieldGenerator implements Generator {

    List<Class> annotationClasses = new ArrayList<>();
    private List<String> annotations = new ArrayList<>();
    private List<Integer> modifiers = new ArrayList<>();
    Class clazz;
    private String name;
    private String defaultValue;
    private StringBuilder result;

    public FieldGenerator(Class clazz, String name) {
        this.clazz = clazz;
        this.name = name;
    }

    public FieldGenerator addAnnotation(Class<? extends Annotation> annotationClass, String... parameters) {
        String annotation = annotationClass.getSimpleName();
        if (parameters.length > 0) {
            annotation = annotation + "(" + String.join(",", parameters) + ")";
        }
        this.annotations.add(annotation);
        this.annotationClasses.add(annotationClass);
        return this;
    }

    public FieldGenerator addModifier(Integer modifier) {
        this.modifiers.add(modifier);
        this.modifiers.sort(Integer::compareTo);
        return this;
    }

    public FieldGenerator setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    @Override
    public FieldGenerator generate() {
        result = new StringBuilder();

        // annotations
        if (!annotations.isEmpty()) {
            annotations.forEach((annotation -> result.append("    @").append(annotation).append("\n")));
        }
        result.append("    ");

        // modifiers
        modifiers.forEach((modifier) -> result.append(Modifier.toString(modifier)).append(" "));

        // class name
        result.append(clazz.getSimpleName()).append(" ");

        // field name
        result.append(name).append(" ");

        // default value
        if (defaultValue != null) {
            result.append("= ").append(defaultValue);
        }
        result.append(";");

        return this;
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
