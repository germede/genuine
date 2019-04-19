package org.fwf.net;

import com.sun.net.httpserver.HttpHandler;
import org.fwf.log.Log;
import org.fwf.mvc.Controller;
import org.fwf.obj.ClassRegister;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Routing {

    private static HashMap<String, HttpHandler> routeHandlerMap;

    static Map<String, HttpHandler> getRouteHandlerMap() {
        if (routeHandlerMap == null) {
            routeHandlerMap = new HashMap<>();
            fillRouteHandlerMap();
        }
        return routeHandlerMap;
    }

    private static void fillRouteHandlerMap() {
        Set<Controller> controllerInstances = ClassRegister.getInstance().getControllerInstances();
        for (Controller controller : controllerInstances) {

            Class<? extends Controller> controllerClass = controller.getClass();
            String baseRouteValue = retrieveControllerBaseRoute(controllerClass);

            // check if base route is valid
            if (baseRouteValue == null) {
                Log.w("Invalid route for controller " +
                        controllerClass.getCanonicalName());
                continue;
            }

            Method[] actions = controllerClass.getDeclaredMethods();
            for (Method action : actions) {

                String route = retrieveControllerMethodRoute(baseRouteValue, action);

                // check if route is valid
                if (route == null) {
                    Log.w("Invalid route for controller action " +
                            controllerClass.getCanonicalName() + "->" + action.getName());
                    continue;
                }

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

    private static String retrieveControllerBaseRoute(Class<? extends Controller> controllerClass) {
        if (controllerClass.isAnnotationPresent(BaseRoute.class)) {
            return controllerClass.getAnnotation(BaseRoute.class).value();
        } else {
            return null;
        }
    }

    private static String retrieveControllerMethodRoute(String baseRouteValue, Method declaredMethod) {
        if (declaredMethod.isAnnotationPresent(Route.class)) {
            return baseRouteValue + declaredMethod.getAnnotation(Route.class).value();
        } else {
            return null;
        }
    }

    private static void invokeControllerAction(Controller controller, Method declaredMethod) {
        try {
            declaredMethod.invoke(controller);
        } catch (IllegalAccessException | InvocationTargetException e) {
            Log.e(e.getMessage(), e);
        }
    }
}
