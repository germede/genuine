package org.fluentness.controller.web;

import org.fluentness.controller.web.AbstractWebController.Request;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

@FunctionalInterface
public interface WebActionReference extends Serializable {

    Object execute(Request request);

    default boolean isAnnotationPresent(Class<? extends Annotation> annotation) {
        Method method = getMethod();
        return method != null && method.isAnnotationPresent(annotation);
    }

    default <T extends Annotation> T getAnnotation(Class<T> annotation) {
        Method method = getMethod();
        if (method != null) {
            return method.getAnnotation(annotation);
        }
        return null;
    }

    default Method getMethod() {
        try {
            Method m = getClass().getDeclaredMethod("writeReplace");
            m.setAccessible(true);
            Object replacement = m.invoke(this);
            if (!(replacement instanceof SerializedLambda)) {
                return null;
            }
            SerializedLambda l = ((SerializedLambda) replacement);
            return l
                .getCapturedArg(0)
                .getClass()
                .getMethod(l.getImplMethodName(), Request.class);
        } catch (Exception ignored) {
        }
        return null;
    }
}
