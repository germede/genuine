package org.fluentness.generator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodGenerator implements Generator {

    List<Class> annotationClasses = new ArrayList<>();
    private List<String> annotations = new ArrayList<>();
    Class returnClass;
    private List<Integer> modifiers = new ArrayList<>();
    private String name;
    List<Class> parameterClasses = new ArrayList<>();
    List<String> parameters = new ArrayList<>();
    private String[] implementationLines;
    private StringBuilder result;

    public MethodGenerator(Class returnClass, String name) {
        this.returnClass = returnClass;
        this.name = name;
    }

    public MethodGenerator addAnnotation(Class<? extends Annotation> annotationClass, String parameters) {
        String annotation = annotationClass.getSimpleName();
        if (!parameters.isEmpty()) {
            annotation = annotation + "(" + parameters + ")";
        }
        this.annotations.add(annotation);
        this.annotationClasses.add(annotationClass);
        return this;
    }

    public MethodGenerator addModifier(Integer modifier) {
        this.modifiers.add(modifier);
        this.modifiers.sort(Integer::compareTo);
        return this;
    }

    public MethodGenerator addParameter(Class clazz, String name) {
        this.parameterClasses.add(clazz);
        this.parameters.add(clazz.getSimpleName() + " " + name);
        return this;
    }

    public MethodGenerator setImplementationLines(String... implementationLines) {
        this.implementationLines = implementationLines;
        return this;
    }

    @Override
    public MethodGenerator generate() {
        result = new StringBuilder();

        // annotations
        if (!annotations.isEmpty()) {
            annotations.forEach((annotation -> result.append("    @").append(annotation).append("\n")));
        }
        result.append("    ");

        // modifiers
        modifiers.forEach((modifier) -> result.append(Modifier.toString(modifier)).append(" "));

        // method name
        result.append(returnClass.getSimpleName()).append(" ");

        // field name
        result.append(name).append(" ");

        // parameters and open
        result.append("(");
        result.append(parameters.stream().collect(Collectors.joining(", ")));
        result.append(") {\n");

        // implementations
        Arrays.stream(implementationLines).forEach(implementationLine -> result.append("        ").append(implementationLine).append("\n"));

        // close
        result.append("    }\n");

        return this;
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
