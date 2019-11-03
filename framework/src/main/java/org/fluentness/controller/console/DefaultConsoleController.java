package org.fluentness.controller.console;

import org.fluentness.Fluentness;
import org.fluentness.controller.Controller;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.service.dependency.DependencyService;
import org.fluentness.service.logger.LoggerService;
import org.fluentness.service.server.ServerService;

import java.io.File;
import java.lang.reflect.Method;
import java.util.*;

import static org.fluentness.service.logger.AnsiColor.*;

public class DefaultConsoleController extends AbstractConsoleController {


    private DependencyService dependency;
    private ServerService server;
    private LoggerService logger;

    public DefaultConsoleController(DependencyService dependency, ServerService server, LoggerService logger) {
        this.dependency = dependency;
        this.server = server;
        this.logger = logger;
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

        List<Controller.Action> actions = new LinkedList<>();
        dependency.getInstances(AbstractConsoleController.class)
            .forEach(abstractConsoleController -> actions.addAll(abstractConsoleController.getActions()));

        // categorize console actions
        for (Controller.Action action : actions) {
            Method method = action.getMethod();
            String category = method.getAnnotation(Action.class).category();
            if (!categorizedConsoleActions.containsKey(category)) {
                categorizedConsoleActions.put(category, new ArrayList<>());
            }
            String inLineParameters = method.getParameterCount() > 0 ?
                Arrays.stream(method.getParameters())
                    .map(entry -> " [" + entry.getName() + ":" + entry.getType().getSimpleName() + "]")
                    .reduce(String::concat)
                    .get()
                : "";
            String actionLine = String.format(ANSI_PURPLE + "    %-40s" + ANSI_RESET + "%s",
                method.getName() + inLineParameters,
                " " + method.getAnnotation(Action.class).description()
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

    @Action(description = "Starts desktop application", category = "desktop")
    public void desktop() {
        dependency.getInstances(AbstractDesktopController.class).forEach(controller -> controller.getDesktopView().render());
    }

    @Action(description = "Starts embedded HTTP web server", category = "web")
    public void web() throws Exception {
        server.start();
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
                logger.warning("Cannot delete %s", file.getPath());
            } else {
                logger.debug("Deleted file %s", file.getPath());
            }
        }
    }
}

