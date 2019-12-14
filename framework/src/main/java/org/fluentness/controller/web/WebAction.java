package org.fluentness.controller.web;

import org.fluentness.server.Request;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

@FunctionalInterface
public interface WebAction extends Serializable {

    Object execute(Request request);

    default Method getMethod() {
        try {
            Method method = this.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(true);
            Object replacement = method.invoke(this);
            if (replacement instanceof SerializedLambda) {
                SerializedLambda serializedLambda = ((SerializedLambda) replacement);
                return serializedLambda
                    .getCapturedArg(0)
                    .getClass()
                    .getMethod(serializedLambda.getImplMethodName(), Request.class);
            }
        } catch (Exception ignored) {
        }
        return null;
    }

    default String getPath() {
        return getMethod().getAnnotation(AbstractWebController.Action.class).path();
    }

    default String getHttpMethod() {
        return getMethod().getAnnotation(AbstractWebController.Action.class).method();
    }
}
