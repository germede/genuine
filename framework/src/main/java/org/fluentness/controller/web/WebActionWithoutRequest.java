package org.fluentness.controller.web;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;

@FunctionalInterface
public interface WebActionWithoutRequest extends Serializable {

    Object execute(HttpServletRequest T);

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
                .getMethod(l.getImplMethodName(), HttpServletRequest.class)
                .getAnnotation(AbstractWebController.Action.class)
                .path();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
