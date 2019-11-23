package org.fluentness.controller.web;

import org.fluentness.controller.web.AbstractWebController.Request;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

@FunctionalInterface
public interface WebActionReference extends Serializable {

    Object execute(Request request);

    default String getPath() {
        return getAction().path();
    }

    default String getMethod() {
        return getAction().method();
    }

    default AbstractWebController.Action getAction() {
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
                .getMethod(l.getImplMethodName(), Request.class)
                .getAnnotation(AbstractWebController.Action.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
