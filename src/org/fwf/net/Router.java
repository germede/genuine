package org.fwf.net;

import com.sun.net.httpserver.HttpHandler;
import org.fwf.ann.BaseRoute;
import org.fwf.ann.Route;
import org.fwf.log.Log;
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

            List<Method> actions = filterMethodsWithRoute(controllerClass.getDeclaredMethods());
            for (Method action : actions) {

                String route = baseRouteValue + action.getAnnotation(Route.class).value();;

                // check if route is already registered
                if (routeHandlerMap.containsKey(route)) {
                    Log.w("Cannot register action " +
                            controllerClass.getCanonicalName() + "->" + action.getName() +
                            "() because route '" + route + "' is already registered");
                    continue;
                }

                routeHandlerMap.put(route, httpExchange -> {
                    invokeControllerAction(controller, action);
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

    private static void invokeControllerAction(Controller controller, Method declaredMethod) {
        try {
            declaredMethod.invoke(controller);
        } catch (IllegalAccessException | InvocationTargetException e) {
            Log.e(e.getMessage(), e);
        }
    }
}
