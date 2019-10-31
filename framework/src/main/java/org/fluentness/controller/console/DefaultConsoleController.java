package org.fluentness.controller.console;

import org.fluentness.DependencyInjector;
import org.fluentness.Fluentness;
import org.fluentness.controller.Controller;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.service.logger.LoggerService;
import org.fluentness.service.server.ServerService;

import java.io.File;
import java.lang.reflect.Method;
import java.util.*;

import static org.fluentness.controller.console.AnsiColor.*;

public class DefaultConsoleController extends AbstractConsoleController {


    private ServerService serverService;
    private LoggerService loggerService;

    public DefaultConsoleController(ServerService serverService, LoggerService loggerService) {
        this.serverService = serverService;
        this.loggerService = loggerService;
    }

    @Action(description = "Prints all available console actions")
    public void help() {

        System.out.println("\n"
                + " _______                                \n"
                + "(  /  //             _/_                \n"
                + " -/--// , , _  _ _   /  _ _   _  (   (  \n"
                + "_/  (/_(_/_(/_/ / /_(__/ / /_(/_/_)_/_)_\n"
        );

        System.out.println(ANSI_GREEN + "Available console actions:" + ANSI_RESET);

        Map<String, List<String>> categorizedConsoleActions = new TreeMap<>();

        // categorize console actions
        for (Method action : Controller.getAllActions(DependencyInjector.does.getInstances(AbstractConsoleController.class))) {
            String category = action.getAnnotation(Action.class).category();
            if (!categorizedConsoleActions.containsKey(category)) {
                categorizedConsoleActions.put(category, new ArrayList<>());
            }
            String inLineParameters = action.getParameterCount() > 0 ?
                    Arrays.stream(action.getParameters())
                            .map(entry -> " [" + entry.getName() + ":" + entry.getType().getSimpleName() + "]")
                            .reduce(String::concat)
                            .get()
                    : "";
            String actionLine = String.format(ANSI_PURPLE + "    %-40s" + ANSI_RESET + "%s",
                    action.getName() + inLineParameters,
                    " " + action.getAnnotation(Action.class).description()
            );
            categorizedConsoleActions.get(category).add(actionLine);
        }

        // print console actions
        categorizedConsoleActions.forEach((key, value) -> {
            System.out.println(String.format(ANSI_BLUE + "%-40s" + ANSI_RESET, key + (!key.isEmpty() ? ":" : "")));
            value.forEach(System.out::println);
            System.out.println();
        });
    }

    @Action(description = "Prints used framework version")
    public void version() {
        // todo fix
        System.out.println(Fluentness.class.getPackage().getImplementationVersion());
    }

    @Action(description = "Clears the view cache", category = "clear")
    public void clear_view_cache() {
//        deleteRecursively(PrivateDirectories.VIEW_CACHE);
    }

    @Action(description = "Clears the style cache", category = "clear")
    public void clear_style_cache() {
//        deleteRecursively(PublicDirectories.STYLES);
    }

    @Action(description = "Clears the logger files", category = "clear")
    public void clear_logs() {
//        deleteRecursively(PrivateDirectories.LOG);
    }

    @Action(description = "Starts embedded HTTP server", category = "server")
    public void server_start() {
        serverService.prepare(AbstractWebController.getRoutingMap(DependencyInjector.does.getInstances(AbstractWebController.class)));
        serverService.start();
    }

    @Action(description = "Stops embedded HTTP server", category = "server")
    public void server_stop() {
        serverService.stop();
    }

    private void deleteRecursively(String path) {
        deleteRecursively(new File(path));
    }

    private void deleteRecursively(File file) {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteRecursively(entry);
                }
            }
        }
        if (file.exists()) {
            if (!file.delete()) {
                loggerService.warning("Cannot delete %s", file.getPath());
            } else {
                loggerService.debug("Deleted file %s", file.getPath());
            }
        }
    }
}

