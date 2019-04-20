package org.fwf.net;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fwf.ann.BaseRoute;
import org.fwf.ann.Route;
import org.fwf.log.Logger;
import org.fwf.mvc.Controller;
import org.fwf.obj.Register;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

class Router {

    private static HashMap<String, HttpHandler> routeHandlerMap;

    static Map<String, HttpHandler> getRouteHandlerMap() {
        if (routeHandlerMap == null) {
            routeHandlerMap = new HashMap<>();
            fillRouteHandlerMap();
        }
        return routeHandlerMap;
    }

    private static void fillRouteHandlerMap() {
        Set<Controller> controllerInstances = Register.getInstance().getControllerInstances();
        for (Controller controller : controllerInstances) {

            Class<? extends Controller> controllerClass = controller.getClass();
            String baseRouteValue = controllerClass.isAnnotationPresent(BaseRoute.class) ?
                    controllerClass.getAnnotation(BaseRoute.class).value() :
                    "";

            List<Method> methodsWithRoute = filterMethodsWithRoute(controllerClass.getDeclaredMethods());
            for (Method methodWithRout : methodsWithRoute) {

                String route = baseRouteValue + methodWithRout.getAnnotation(Route.class).path();

                // check if route is already registered
                if (routeHandlerMap.containsKey(route)) {
                    Logger.w("Cannot register controller method %s->%s because route '%s' is already registered",
                            controllerClass.getCanonicalName(),
                            methodWithRout.getName(),
                            route);
                    continue;
                }

                routeHandlerMap.put(route, httpExchange -> {
                    invokeControllerMethod(controller, methodWithRout, httpExchange);
                    httpExchange.close();
                });
            }
        }
    }

    private static List<Method> filterMethodsWithRoute(Method[] declaredMethods) {
        List<Method> result = new ArrayList<>();
        for (Method declaredMethod : declaredMethods) {
            if (declaredMethod.isAnnotationPresent(Route.class)) {
                result.add(declaredMethod);
            }
        }
        return result;
    }

    private static void invokeControllerMethod(Controller controller, Method declaredMethod, HttpExchange httpExchange) {
        try {
            if (httpExchange.getRequestMethod().equals(declaredMethod.getAnnotation(Route.class).method())) {
                declaredMethod.invoke(controller);
            } else {
                Logger.w("HTTP Method mismatch in controller method %s->%s (declared: %s) , got: %s)",
                        controller.getClass().getCanonicalName(),
                        declaredMethod.getName(),
                        declaredMethod.getAnnotation(Route.class).method(),
                        httpExchange.getRequestMethod());
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            Logger.e("Error executing controller method %s->%s",
                    controller.getClass().getCanonicalName(),
                    (declaredMethod.getName()));
        }
    }
}
