package org.fluentness.networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.common.ClassRegister;
import org.fluentness.controller.BaseRoute;
import org.fluentness.controller.Controller;
import org.fluentness.controller.Route;
import org.fluentness.logging.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class HttpRouter {

    private HttpRouter() {
    }

    public static Map<String, HttpHandler> getRouteHandlerMap() {
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
                    Log.warning(HttpRouter.class,
                            "Cannot register controller method %s->%s because route '%s' is already registered",
                            controllerClass.getCanonicalName(),
                            methodWithRoute.getName(), route);
                    continue;
                }

                // controller method must return HttpResponse
                if (methodWithRoute.getReturnType() != HttpResponse.class) {
                    Log.warning(HttpRouter.class,
                            "Controller method %s->%s with defined route must return an object of type " + HttpResponse.class.getCanonicalName(),
                            controllerClass.getCanonicalName(),
                            methodWithRoute.getName(), route);
                    continue;
                }

                routeHandlerMap.put(route.replaceAll("//", "/"), httpExchange -> {
                    Log.info(HttpRouter.class, httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());
                    invokeControllerMethod(controller, methodWithRoute, httpExchange);
                });
            }

            // static resource manager
            routeHandlerMap.put("/res/", new HttpResourceHandler());

            // favicon route
            routeHandlerMap.put("/favicon.ico", new HttpResourceHandler());
        }

        return routeHandlerMap;
    }


    private static void invokeControllerMethod(Controller controller, Method method, HttpExchange httpExchange) {
        try {
            if (httpExchange.getRequestMethod().equals(method.getAnnotation(Route.class).method())) {

                // invoke controller method and serve
                HttpResponse response = (HttpResponse) method.invoke(controller, new HttpRequest(httpExchange));
                HttpServer.serve(httpExchange, response);

            } else {

                // client request method mismatch
                Log.warning(HttpRouter.class,
                        "HTTP Method mismatch in controller method %s->%s (declared: %s , got: %s)",
                        controller.getClass().getCanonicalName(),
                        method.getName(),
                        method.getAnnotation(Route.class).method(), httpExchange.getRequestMethod());
                HttpServer.serve(httpExchange, new HttpResponse(HttpStatusCode.BadRequest));
            }

            // exception due to inaccessible controller method
        } catch (IllegalAccessException e) {
            Log.severe(HttpRouter.class, e);
            HttpServer.serve(httpExchange, new HttpResponse(HttpStatusCode.InternalServerError));

            // exception within controller method invocation
        } catch (InvocationTargetException e) {
            Log.severe(HttpRouter.class,
                    (Exception) e.getTargetException(),
                    e.getMessage(),
                    controller.getClass().getCanonicalName(),
                    (method.getName()));
            HttpServer.serve(httpExchange, new HttpResponse(HttpStatusCode.InternalServerError));
        } catch (Exception e) {
            Log.severe(HttpRouter.class, e);
        }
    }
}
