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

            // retrieve controller base route
            Class<? extends Controller> controllerClass = controller.getClass();
            String baseRouteValue = controllerClass.isAnnotationPresent(BaseRoute.class) ?
                    controllerClass.getAnnotation(BaseRoute.class).value() :
                    "";

            // retrieve controller methods with route
            List<Method> methodsWithRoute = filterMethodsWithRoute(controllerClass.getDeclaredMethods());
            for (Method methodWithRoute : methodsWithRoute) {

                String route = baseRouteValue + methodWithRoute.getAnnotation(Route.class).path();

                // already registered method warning
                if (routeHandlerMap.containsKey(route)) {
                    Logger.w("Cannot register controller method %s->%s because route '%s' is already registered",
                            controllerClass.getCanonicalName(),
                            methodWithRoute.getName(),
                            route);
                    continue;
                }

                // controller methdo must return HttpResponse
                if (methodWithRoute.getReturnType() != HttpResponse.class) {
                    Logger.w("Controller method %s->%s MUST return an object of type " + HttpResponse.class.getCanonicalName(),
                            controllerClass.getCanonicalName(),
                            methodWithRoute.getName(),
                            route);
                    continue;
                }

                routeHandlerMap.put(route, httpExchange -> {
                    Logger.d(httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());
                    invokeControllerMethod(controller, methodWithRoute, httpExchange);
                });
            }

            // static resource manager
            routeHandlerMap.put("/res/", new ResourceHandler());

            // favicon route
            routeHandlerMap.put("/favicon.ico", new ResourceHandler());
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

    private static void invokeControllerMethod(Controller controller, Method method, HttpExchange httpExchange) {
        try {
            if (httpExchange.getRequestMethod().equals(method.getAnnotation(Route.class).method())) {

//                Parameter[] methodParameters = method.getParameters();
//                for (Parameter parameter : methodParameters) {
//                    if (parameter.getType().equals(httpExchange.getRequest))
//                }
//
//                if (method.getParameters())

                Server.respond(httpExchange, (HttpResponse) method.invoke(controller));
            } else {

                // client request method mismatch
                Logger.w("HTTP Method mismatch in controller method %s->%s (declared: %s) , got: %s)",
                        controller.getClass().getCanonicalName(),
                        method.getName(),
                        method.getAnnotation(Route.class).method(),
                        httpExchange.getRequestMethod());
                Server.respond(httpExchange, new HttpResponse(HttpStatusCode.BadRequest));
            }

            // exception due to inaccessible controller method
        } catch (IllegalAccessException e) {
            Logger.e(e);
            Server.respond(httpExchange, new HttpResponse(HttpStatusCode.InternalServerError));

            // exception within controller method invocation
        } catch (InvocationTargetException e) {
            Logger.e((Exception) e.getTargetException(),
                    e.getMessage(),
                    controller.getClass().getCanonicalName(),
                    (method.getName()));
            Server.respond(httpExchange, new HttpResponse(HttpStatusCode.InternalServerError));
        }
    }



}
