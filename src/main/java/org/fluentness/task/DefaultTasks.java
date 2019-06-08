package org.fluentness.task;

import org.fluentness.FnAtoz;
import org.fluentness.common.Utils;
import org.fluentness.common.logging.Logger;
import org.fluentness.common.namedValues.NamedValue;
import org.fluentness.common.networking.HttpServer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class DefaultTasks implements TaskProvider {

    public Task help = commands(
        help -> command("Prints all available commands",
            (parameters) -> {
                System.out.println("\n" +
                    " _______                                \n" +
                    "(  /  //             _/_                \n" +
                    " -/--// , , _  _ _   /  _ _   _  (   (  \n" +
                    "_/  (/_(_/_(/_/ / /_(__/ / /_(/_/_)_/_)_\n");

                System.out.println(ANSI_GREEN + "Available tasks:\n" + ANSI_RESET);

                // merge default and custom tasks
                Map<String, Task> tasks = new DefaultTasks().provideAll();
                tasks.putAll(FnAtoz.getTaskProvider().provideAll());
                tasks = new TreeMap<>(tasks);

                for (Map.Entry<String, Task> task : tasks.entrySet()) {

                    if (task.getValue().getCommands().length == 1) {
                        NamedValue<Command> command = task.getValue().getCommands()[0];
                        String parametersToPrint = command.value().getParameters().length > 0 ?
                            Arrays.toString(command.value().getParameters()) :
                            "";
                        System.out.println(String.format(ANSI_BLUE + "%-30s" + ANSI_RESET + "%s",
                            command.name() + " " + parametersToPrint,
                            task.getValue().getCommands()[0].value().getDescription()
                        ));
                        continue;
                    }
                    System.out.println(String.format(ANSI_BLUE + "%-30s" + ANSI_RESET,
                        task.getKey() + ":"
                    ));
                    for (NamedValue<Command> command : task.getValue().getCommands()) {
                        String parametersToPrint = command.value().getParameters().length > 0 ?
                            Arrays.toString(command.value().getParameters()) :
                            "";
                        System.out.println(String.format(ANSI_PURPLE + "%-30s" + ANSI_RESET + "%s",
                            "    " + task.getKey() + ":" + command.name() + " " + parametersToPrint,
                            command.value().getDescription()
                        ));
                    }
                }

            }
        )
    );

    Task version = commands(
        version -> command("Prints current Fluentness version",
            parameters -> System.out.println("1.0-dev")
        )
    );

    Task clear = commands(
        cache -> command("Clears the cache files by deleting directory tmp/cache",
            parameters -> Utils.deleteDirectoryRecursively(new File("tmp/cache"))
        ),

        logs -> command("Clears the log files by deleting directory tmp/logs",
            parameters -> Utils.deleteDirectoryRecursively(new File("tmp/logs"))
        )
    );

    Task server = commands(

        start -> command("Starts embedded HTTP server",
            parameters -> HttpServer.start()
        ),

        stop -> command("Stops embedded HTTP server",
            parameters -> HttpServer.stop()
        )

    );

    Task generate = commands(

        style -> command(parameters("css_file"), "Generates style based on source CSS file",
            parameters -> {

                try {
                    String content = new String(Files.readAllBytes(Paths.get(parameters[0])), StandardCharsets.UTF_8);
                    content = content.replaceAll("foo", "bar");
                    System.out.println(content);
//                    Files.write(path, content.getBytes(charset));
                } catch (IOException e) {
                    Logger.error("Could not read file from path" + parameters[0]);
                }
            }
        ),

        run -> command("Starts embedded HTTP server",
            parameters -> HttpServer.start()
        )
    );


//    @Override
//    public String getDescription() {
//        return "Creates a new controller class within the controller package";
//    }
//
//    @Override
//    public void execute(String... parameters) {
//        String name = parameters[0];
//
//        new ClassGenerator(Utils.toTitelCase(name) + Utils.toTitelCase(PackageNames.CONTROLLER))
//            .setPackage(FnConf.getString(FnConf.APP_PACKAGE) + "." + PackageNames.CONTROLLER)
//            .addModifier(Modifier.PUBLIC)
//            .addAnnotation(Controller.Route.class, "\"/" + name.toLowerCase() + "\"")
//            .addInterface(Controller.class)
//            .addField(
//                new FieldGenerator(Repository.class, "repository")
//                    .addModifier(Modifier.PRIVATE)
//                    .setDefaultValue("new ServerStartCommand()")
//                    .generate()
//            )
//            .addMethod(
//                new MethodGenerator(Response.class, "list")
//                    .addAnnotation(Controller.Route.class, "\"/list\"")
//                    .addModifier(Modifier.PUBLIC)
//                    .addParameter(Request.class, "request")
//                    .setImplementationLines(
//                        "// todo implement list " + name,
//                        "return redirect(\"/\");"
//                    )
//                    .generate()
//            )
//            .addMethod(
//                new MethodGenerator(Response.class, "find")
//                    .addAnnotation(Controller.Route.class, "\"/find/{id}\"")
//                    .addModifier(Modifier.PUBLIC)
//                    .addParameter(Request.class, "request")
//                    .setImplementationLines(
//                        "// todo implement list " + name,
//                        "return redirect(\"/\");"
//                    )
//                    .generate()
//            )
//            .addMethod(
//                new MethodGenerator(Response.class, "create")
//                    .addAnnotation(Controller.Route.class, "\"/create\"")
//                    .addModifier(Modifier.PUBLIC)
//                    .addParameter(Request.class, "request")
//                    .setImplementationLines(
//                        "// todo implement create " + name,
//                        "return redirect(\"/\");"
//                    )
//                    .generate()
//            )
//            .addMethod(
//                new MethodGenerator(Response.class, "update")
//                    .addAnnotation(Controller.Route.class, "\"/update/{id}\"")
//                    .addModifier(Modifier.PUBLIC)
//                    .addParameter(Request.class, "request")
//                    .setImplementationLines(
//                        "// todo implement update " + name,
//                        "return redirect(\"/\");"
//                    )
//                    .generate()
//            )
//            .addMethod(
//                new MethodGenerator(Response.class, "delete")
//                    .addAnnotation(Controller.Route.class, "\"/delete\"")
//                    .addModifier(Modifier.PUBLIC)
//                    .addParameter(Request.class, "request")
//                    .setImplementationLines(
//                        "// todo implement delete " + name,
//                        "return redirect(\"/\");"
//                    )
//                    .generate()
//            )
//            .generate()
//            .writeToFile()
//        ;
//    }
}
