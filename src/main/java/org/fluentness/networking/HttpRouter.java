package org.fluentness.networking;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.controller.Controller;
import org.fluentness.controller.Route;
import org.fluentness.logging.Logger;
import org.fluentness.register.ControllerRegister;
import org.fluentness.register.RequestRegister;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

final class HttpRouter {

    private HttpRouter() {
    }

    static Map<String, HttpHandler> getRouteHandlerMap() {
        Map<String, HttpHandler> routeHandlerMap = new HashMap<>();

        Set<Controller> controllerInstances = ControllerRegister.getControllerInstances();
        for (Controller controller : controllerInstances) {

            // retrieve controller base route
            Class<? extends Controller> controllerClass = controller.getClass();
            String baseRouteValue = controllerClass.isAnnotationPresent(Route.class) ?
                    controllerClass.getAnnotation(Route.class).value() :
                    "";

            // retrieve controller methods with route
            List<Method> methodsWithRoute = new ArrayList<>();
            for (Method declaredMethod : controllerClass.getDeclaredMethods()) {
                if (declaredMethod.isAnnotationPresent(Route.class)) {
                    methodsWithRoute.add(declaredMethod);
                }
            }

            for (Method methodWithRoute : methodsWithRoute) {

                String route = baseRouteValue + methodWithRoute.getAnnotation(Route.class).value();

                // dynamic routes in the middle path are not allowed
                if (route.contains("{") && route.charAt(route.length() - 1) != '}') {
                    Logger.warning(HttpRouter.class,
                            "Controller method %s->%s dynamic url parameter must stay at the end of the path",
                            controllerClass.getCanonicalName(),
                            methodWithRoute.getName());
                    continue;
                }

                // already registered method warning
                if (routeHandlerMap.containsKey(route)) {
                    Logger.warning(HttpRouter.class,
                            "Cannot register controller method %s->%s because route '%s' is already registered",
                            controllerClass.getCanonicalName(),
                            methodWithRoute.getName(), route);
                    continue;
                }

                // controller method must return HttpResponse
                if (methodWithRoute.getReturnType() != Response.class) {
                    Logger.warning(HttpRouter.class,
                            "Controller method %s->%s must return an object of type %s",
                            controllerClass.getCanonicalName(),
                            methodWithRoute.getName(),
                            Response.class.getCanonicalName());
                    continue;
                }

                routeHandlerMap.put(route.replaceAll("\\{.+", "").replace("//", "/"),
                        httpExchange -> {
                            Logger.debug(HttpRouter.class, httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());
                            invokeControllerMethod(controller, methodWithRoute, httpExchange);
                        });
            }

            // static resource manager
            routeHandlerMap.put("/resources/", new HttpResourceHandler());

            // favicon route
            routeHandlerMap.put("/favicon.ico", new HttpResourceHandler());
        }

        return routeHandlerMap;
    }


    private static void invokeControllerMethod(Controller controller, Method method, HttpExchange httpExchange) {
        try {
//            if (httpExchange.getRequestMethod().equals(method.getAnnotation(Route.class).method())) {

            // invoke controller method and serve
            String declaredControllerRoute = controller.getClass().isAnnotationPresent(Route.class) ? controller.getClass().getAnnotation(Route.class).value() : "";
            String declaredRoute = declaredControllerRoute + method.getAnnotation(Route.class).value();

            Request request = new Request(httpExchange, declaredRoute);
            RequestRegister.putCurrent(request);

            Response response;
            if (method.getParameters().length > 0 && method.getParameters()[0].getType().equals(Request.class)) {
                response = (Response) method.invoke(controller, request);
            } else {
                response = (Response) method.invoke(controller);
            }
            RequestRegister.removeCurrent();
            HttpServer.serve(httpExchange, response);

//            } else {
//
//                 client request method mismatch
//                Logger.warning(HttpRouter.class,
//                        "HTTP Method mismatch in controller method %s->%s (declared: %s , got: %s)",
//                        controller.getClass().getCanonicalName(),
//                        method.getName(),
//                        method.getAnnotation(Route.class).value(), httpExchange.getRequestMethod());
//                HttpServer.serve(httpExchange, new HttpResponse(HttpStatusCode.BadRequest));
//            }

            // exception due to inaccessible controller method
        } catch (IllegalAccessException e) {
            Logger.error(HttpRouter.class, e);
            HttpServer.serve(httpExchange, new Response(HttpStatusCode.InternalServerError));
            // exception within controller method invocation
        } catch (InvocationTargetException e) {
            Logger.error(controller.getClass(), (Exception) e.getTargetException());
            HttpServer.serve(httpExchange, new Response(HttpStatusCode.InternalServerError));
        } catch (Exception e) {
            Logger.error(HttpRouter.class, e);
            HttpServer.serve(httpExchange, new Response(HttpStatusCode.InternalServerError));
        }
    }
}
