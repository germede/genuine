package org.fluentness.controller.web;

import org.fluentness.controller.web.AbstractWebController.Request;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

@FunctionalInterface
public interface WebActionReferenceWithRequest extends Serializable {

    Object execute(Request request);

    default String getPath() {
        try {
            Method m = getClass().getDeclaredMethod("writeReplace");
            m.setAccessible(true);
            Object replacement = m.invoke(this);
            if (!(replacement instanceof SerializedLambda)) {
                return "";
            }
            SerializedLambda l = ((SerializedLambda) replacement);
            Method[] methods = l.getCapturedArg(0).getClass().getMethods();
            return  l.getCapturedArg(0)
                .getClass()
                .getMethod(l.getImplMethodName(), Request.class)
                .getAnnotation(AbstractWebController.Action.class)
                .path();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
