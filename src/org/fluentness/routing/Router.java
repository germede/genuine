package org.fluentness.routing;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.controller.BaseRoute;
import org.fluentness.controller.QueryParameter;
import org.fluentness.controller.Route;
import org.fluentness.logging.Logger;
import org.fluentness.controller.Controller;
import org.fluentness.ClassRegister;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

class Router {

    static Map<String, HttpHandler> getRouteHandlerMap() {
        Map<String, HttpHandler> routeHandlerMap = new HashMap<>();

        Set<Controller> controllerInstances = ClassRegister.getControllerInstances();
        for (Controller controller : controllerInstances) {

            // retrieve controller base route
            Class<? extends Controller> controllerClass = controller.getClass();
            String baseRouteValue = controllerClass.isAnnotationPresent(BaseRoute.class) ?
                    controllerClass.getAnnotation(BaseRoute.class).value() :
                    "";

            // retrieve controller methods with route
            List<Method> methodsWithRoute = new ArrayList<>();
            for (Method declaredMethod : controllerClass.getDeclaredMethods()) {
                if (declaredMethod.isAnnotationPresent(Route.class)) {
                    methodsWithRoute.add(declaredMethod);
                }
            }

            for (Method methodWithRoute : methodsWithRoute) {

                String route = baseRouteValue + methodWithRoute.getAnnotation(Route.class).path();

                // already registered method warning
                if (routeHandlerMap.containsKey(route)) {
                    Logger.warning(Router.class,
                            "Cannot register controller method %s->%s because route '%s' is already registered",
                            controllerClass.getCanonicalName(),
                            methodWithRoute.getName(), route);
                    continue;
                }

                // controller method must return HttpResponse
                if (methodWithRoute.getReturnType() != HttpResponse.class) {
                    Logger.warning(Router.class,
                            "Controller method %s->%s with defined route must return an object of type " + HttpResponse.class.getCanonicalName(),
                            controllerClass.getCanonicalName(),
                            methodWithRoute.getName(), route);
                    continue;
                }

                routeHandlerMap.put(route.replaceAll("//", "/"), httpExchange -> {
                    Logger.debug(Router.class, httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());
                    invokeControllerMethod(controller, methodWithRoute, httpExchange);
                });
            }

            // static resource manager
            routeHandlerMap.put("/res/", new ResourceHandler());

            // favicon route
            routeHandlerMap.put("/favicon.ico", new ResourceHandler());
        }

        return routeHandlerMap;
    }


    private static void invokeControllerMethod(Controller controller, Method method, HttpExchange httpExchange) {
        try {
            if (httpExchange.getRequestMethod().equals(method.getAnnotation(Route.class).method())) {

                Map<String, String> getParameters = extractGetParameters(httpExchange.getRequestURI().getQuery());
                Parameter[] methodParameters = method.getParameters();
                String[] result = new String[methodParameters.length];
                for (int i = 0; i < methodParameters.length; i++) {
                    Parameter parameter = methodParameters[i];
                    if (parameter.isAnnotationPresent(QueryParameter.class)) {
                        result[i] = getParameters.get(parameter.getAnnotation(QueryParameter.class).value());
                    }
                }

                HttpResponse response = (HttpResponse) method.invoke(controller, (Object[]) result);
                HttpServer.respond(httpExchange, response);

            } else {

                // client request method mismatch
                Logger.warning(Router.class,
                        "HTTP Method mismatch in controller method %s->%s (declared: %s , got: %s)",
                        controller.getClass().getCanonicalName(),
                        method.getName(),
                        method.getAnnotation(Route.class).method(), httpExchange.getRequestMethod());
                HttpServer.respond(httpExchange, new HttpResponse(HttpStatusCode.BadRequest));
            }

            // exception due to inaccessible controller method
        } catch (IllegalAccessException e) {
            Logger.error(Router.class, e);
            HttpServer.respond(httpExchange, new HttpResponse(HttpStatusCode.InternalServerError));

            // exception within controller method invocation
        } catch (InvocationTargetException e) {
            Logger.error(Router.class,
                    (Exception) e.getTargetException(),
                    e.getMessage(),
                    controller.getClass().getCanonicalName(), (method.getName()));
            HttpServer.respond(httpExchange, new HttpResponse(HttpStatusCode.InternalServerError));
        }
    }

    private static Map<String, String> extractGetParameters(String query) {
        Map<String, String> result = new HashMap<>();
        if (query == null || query.isEmpty()) {
            return result;
        }
        for (String param : query.split("&")) {
            String[] entry = param.split("=");
            if (entry.length > 1) {
                result.put(entry[0], entry[1]);
            } else {
                result.put(entry[0], "");
            }
        }
        return result;
    }

}
