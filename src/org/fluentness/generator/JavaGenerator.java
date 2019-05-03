package org.fluentness.generator;

import org.fluentness.logging.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class JavaGenerator implements Generator {

    private String path;
    private String packageName;
    private List<Class> imports = new ArrayList<>();
    private List<Integer> modifiers = new ArrayList<>();
    private String className;
    private String parent;
    private List<String> interfaces = new ArrayList<>();


    public JavaGenerator(String path, String className) {
        this.path = path;
        this.className = className;
    }

    public JavaGenerator setPackage(String packageName) {
        this.packageName = packageName;
        return this;
    }

    public JavaGenerator addImports(Class... imports) {
        Collections.addAll(this.imports, imports);
        return this;
    }

    public JavaGenerator addModifiers(Integer... modifiers) {
        Collections.addAll(this.modifiers, modifiers);
        this.modifiers.sort(Integer::compareTo);
        return this;
    }

    public JavaGenerator setParent(Class parentClass) {
        this.imports.add(parentClass);
        this.parent = parentClass.getSimpleName();
        return this;
    }

    public JavaGenerator addInterfaces(Class... interfaceClasses) {
        for (Class interfaceClass : interfaceClasses) {
            this.imports.add(interfaceClass);
            this.interfaces.add(interfaceClass.getSimpleName());
        }
        return this;
    }

    @Override
    public boolean generate() {
        StringBuilder result = new StringBuilder();

        // package
        if (packageName != null) {
            result.append("package ").append(packageName).append(";\n\n");
        }

        // imports
        if (!imports.isEmpty()) {
            imports.forEach((importsItem -> result.append("import ").append(importsItem.getCanonicalName()).append(";\n")));
            result.append("\n");
        }

        // modifiers
        modifiers.forEach((modifier) -> result.append(Modifier.toString(modifier)).append(" "));

        // class
        result.append("class ");

        // parent
        if (parent != null) {
            result.append("extends ").append(parent).append(" ");
        }

        // interfaces
        if (!interfaces.isEmpty()) {
            result.append("implements ").append(interfaces.stream().collect(Collectors.joining(","))).append(" ");
        }

        // open
        result.append("{\n");

        // close
        result.append("}");


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/" + className + ".java"));
            writer.write(result.toString());
            writer.close();
            return true;
        } catch (IOException e) {
            Logger.severe(this.getClass(), e);
        }
        return false;
    }
}
