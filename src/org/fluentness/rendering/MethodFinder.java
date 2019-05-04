package org.fluentness.rendering;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Objects;

interface MethodFinder extends Serializable {
    default SerializedLambda serialized() {
        try {
            Method replaceMethod = getClass().getDeclaredMethod("writeReplace");
            replaceMethod.setAccessible(true);
            return (SerializedLambda) replaceMethod.invoke(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    default Class<?> getContainingClass() {
        try {
            String className = serialized().getImplClass().replace("/", ".");
            return Class.forName(className);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    default Method method() {
        SerializedLambda lambda = serialized();
        Class<?> containingClass = getContainingClass();
        return Arrays.stream(containingClass.getDeclaredMethods())
                .filter(method -> Objects.equals(method.getName(), lambda.getImplMethodName()))
                .findFirst()
                .orElseThrow(UnableToGuessMethodException::new);
    }

    default Parameter parameter(int n) {
        return method().getParameters()[n];
    }

    class UnableToGuessMethodException extends RuntimeException {}
}