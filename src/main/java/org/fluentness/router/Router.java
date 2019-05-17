package org.fluentness.router;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.fluentness.controller.Controller;
import org.fluentness.controller.Request;
import org.fluentness.controller.Response;
import org.fluentness.logger.Logger;
import org.fluentness.register.ControllerRegister;
import org.fluentness.register.RequestRegister;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

final class Router {

    private Router() {
    }

    static Map<String, HttpHandler> getRouteHandlerMap() {
        Map<String, HttpHandler> routeHandlerMap = new HashMap<>();

        Set<Controller> controllerInstances = ControllerRegister.getControllerInstances();
        for (Controller controller : controllerInstances) {

            // retrieve controller base route
            Class<? extends Controller> controllerClass = controller.getClass();
            String baseRouteValue = controllerClass.isAnnotationPresent(Controller.Route.class) ?
                    controllerClass.getAnnotation(Controller.Route.class).value() :
                    "";

            // retrieve controller methods with route
            List<Method> methodsWithRoute = new ArrayList<>();
            for (Method declaredMethod : controllerClass.getDeclaredMethods()) {
                if (declaredMethod.isAnnotationPresent(Controller.Route.class)) {
                    methodsWithRoute.add(declaredMethod);
                }
            }

            for (Method methodWithRoute : methodsWithRoute) {

                String route = baseRouteValue + methodWithRoute.getAnnotation(Controller.Route.class).value();

                // dynamic routes in the middle path are not allowed
                if (route.contains("{") && route.charAt(route.length() - 1) != '}') {
                    Logger.warning(Router.class,
                            "Controller method %s->%s dynamic url parameter must stay at the end of the path",
                            controllerClass.getCanonicalName(),
                            methodWithRoute.getName());
                    continue;
                }

                // already registered method warning
                if (routeHandlerMap.containsKey(route)) {
                    Logger.warning(Router.class,
                            "Cannot register controller method %s->%s because route '%s' is already registered",
                            controllerClass.getCanonicalName(),
                            methodWithRoute.getName(), route);
                    continue;
                }

                // controller method must return HttpResponse
                if (methodWithRoute.getReturnType() != Response.class) {
                    Logger.warning(Router.class,
                            "Controller method %s->%s must return an object of type %s",
                            controllerClass.getCanonicalName(),
                            methodWithRoute.getName(),
                            Response.class.getCanonicalName());
                    continue;
                }

                routeHandlerMap.put(route.replaceAll("\\{.+", "").replace("//", "/"),
                        httpExchange -> {
                            Logger.debug(Router.class, httpExchange.getRequestMethod() + " " + httpExchange.getRequestURI());
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
            // invoke controller method and serve
            String declaredControllerRoute = controller.getClass().isAnnotationPresent(Controller.Route.class) ? controller.getClass().getAnnotation(Controller.Route.class).value() : "";
            String declaredRoute = declaredControllerRoute + method.getAnnotation(Controller.Route.class).value();

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

            // exception due to inaccessible controller method
        } catch (IllegalAccessException e) {
            Logger.error(Router.class, e);
            HttpServer.serve(httpExchange, new Response(HttpStatusCode.InternalServerError));
            // exception within controller method invocation
        } catch (InvocationTargetException e) {
            Logger.error(controller.getClass(), (Exception) e.getTargetException());
            HttpServer.serve(httpExchange, new Response(HttpStatusCode.InternalServerError));
        } catch (Exception e) {
            Logger.error(Router.class, e);
            HttpServer.serve(httpExchange, new Response(HttpStatusCode.InternalServerError));
        }
    }
}
