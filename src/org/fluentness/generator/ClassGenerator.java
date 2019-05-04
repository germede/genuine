package org.fluentness.generator;

import org.fluentness.logging.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClassGenerator implements Generator {

    private String packageName;
    private List<Class> imports = new ArrayList<>();
    private List<String> annotations = new ArrayList<>();
    private List<Integer> modifiers = new ArrayList<>();
    private String className;
    private String parent;
    private List<String> interfaces = new ArrayList<>();
    private List<String> fields = new ArrayList<>();
    private StringBuilder result;

    public ClassGenerator(String className) {
        this.className = className;
    }

    public ClassGenerator setPackage(String packageName) {
        this.packageName = packageName;
        return this;
    }

    public ClassGenerator setParent(Class parentClass) {
        this.imports.add(parentClass);
        this.parent = parentClass.getSimpleName();
        return this;
    }

    public ClassGenerator addImport(Class importClass) {
        if (this.imports.stream().noneMatch(importItem->importItem.getCanonicalName().equals(importClass.getCanonicalName()))) {
            this.imports.add(importClass);
        }
        return this;
    }

    public ClassGenerator addAnnotation(Class<? extends Annotation> annotationClass, String parameters) {
        addImport(annotationClass);
        String annotation = annotationClass.getSimpleName();
        if (!parameters.isEmpty()) {
            annotation = annotation + "(" + parameters + ")";
        }
        this.annotations.add(annotation);
        return this;
    }

    public ClassGenerator addModifier(Integer modifier) {
        this.modifiers.add(modifier);
        this.modifiers.sort(Integer::compareTo);
        return this;
    }

    public ClassGenerator addInterface(Class interfaceClass) {
        addImport(interfaceClass);
        this.interfaces.add(interfaceClass.getSimpleName());
        return this;
    }

    public ClassGenerator addField(FieldGenerator fieldGenerator) {
        addImport(fieldGenerator.clazz);
        fieldGenerator.annotationClasses.stream().forEach(this::addImport);
        this.fields.add(fieldGenerator.generate().toString());
        return this;
    }

    @Override
    public ClassGenerator generate() {
        result = new StringBuilder();

        // package
        if (packageName != null) {
            result.append("package ").append(packageName).append(";\n\n");
        }

        // imports
        if (!imports.isEmpty()) {
            imports.forEach((importsItem -> result.append("import ").append(importsItem.getCanonicalName()).append(";\n")));
            result.append("\n");
        }

        // annotations
        if (!annotations.isEmpty()) {
            annotations.forEach((annotation -> result.append("@").append(annotation).append("\n")));
        }

        // modifiers
        modifiers.forEach((modifier) -> result.append(Modifier.toString(modifier)).append(" "));

        // class
        result.append("class ").append(className).append(" ");

        // parent
        if (parent != null) {
            result.append("extends ").append(parent).append(" ");
        }

        // interfaces
        if (!interfaces.isEmpty()) {
            result.append("implements ").append(interfaces.stream().collect(Collectors.joining(","))).append(" ");
        }

        // open
        result.append("{\n\n");

        // fields
        result.append(fields.stream().collect(Collectors.joining("\n"))).append("\n");



        // close
        result.append("}");

        return this;
    }

    public String writeToFile() {

        try {
            String path = "src/" + packageName.replace(".", "/");
            new File(path).mkdirs();
            String filePath = path + "/" + className + ".java";
            if (new File(filePath).exists()) {
                throw new IOException("File " + filePath + " already exists");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(result.toString());
            writer.close();
            Logger.info(this.getClass(), "Successfully generated " + filePath);
        } catch (IOException e) {
            Logger.error(this.getClass(), e);
        }
        return result.toString();
    }


}
