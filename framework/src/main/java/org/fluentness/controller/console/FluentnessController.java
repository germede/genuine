package org.fluentness.controller.console;

import org.fluentness.Fluentness;
import org.fluentness.repository.Model;
import org.fluentness.repository.Repository;
import org.fluentness.service.persistence.JdbcPersistence;
import org.fluentness.service.persistence.Persistence;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;
import java.util.List;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.fluentness.service.log.AnsiColor.*;

public final class FluentnessController extends AbstractConsoleController {

    private Persistence persistence;

    public FluentnessController(Persistence persistence) {
        this.persistence = persistence;
    }

    @Action(description = "Prints all available console actions")
    void help() {

        System.out.println("\n"
            + " _______                                \n"
            + "(  /  //             _/_                \n"
            + " -/--// , , _  _ _   /  _ _   _  (   (  \n"
            + "_/  (/_(_/_(/_/ / /_(__/ / /_(/_/_)_/_)_\n"
        );

        System.out.println(GREEN + "Available console actions:" + RESET);

        Map<String, List<String>> categorizedConsoleActions = new TreeMap<>();

        List<Method> actions = new LinkedList<>();
        for (AbstractConsoleController controller : Fluentness.getInstances(AbstractConsoleController.class)) {
            actions.addAll(Arrays.asList(controller.getActions()));
        }

        // categorize console actions
        for (Method action : actions) {
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
            String actionLine = String.format(PURPLE + "    %-40s" + RESET + "%s",
                action.getName() + inLineParameters,
                " " + action.getAnnotation(Action.class).description()
            );
            categorizedConsoleActions.get(category).add(actionLine);
        }

        // print console actions
        categorizedConsoleActions.forEach((key, value) -> {
            System.out.println(String.format(BLUE + "%-40s" + RESET, key + (!key.isEmpty() ? ":" : "")));
            value.forEach(System.out::println);
            System.out.println();
        });
    }

    @Action(category = "html", description = "Converts normal html code into Fluentness compilable code")
    void convert() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        JTextPane input = new JTextPane();
        JButton button = new JButton("Convert");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 300));

        ScrollPane inputScroll = new ScrollPane();
        inputScroll.add(input);

        frame.setLayout(new BorderLayout());
        frame.add(inputScroll, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

        button.addActionListener(e -> {
            input.setText(convert(input.getText()));
        });
    }

    private String convert(String text) {
        final Pattern TAG_PATTERN = Pattern.compile("<(?!!)(?!/)\\s*([a-zA-Z0-9]+)(.*?)>(.+)<");
        final Pattern ATTRIBUTE_PATTERN = Pattern.compile("(\\S+)=['\"]{1}([^>]*?)['\"]{1}");

        text = text.replaceAll("<(\\w+)\\s", "$1(");
        text = text.replaceAll("\\s(\\w+)=\"([\\w\\s]+)\"", "$1 + \"$2\", ");
        text = text.replaceAll("</\\w*>", "),");
        text = text.replaceAll(">", "");
        // todo improve
        return text;
    }

    @Action(category = "sql", description = "Prints out required create sql statements based on existing Models")
    void schema() {
        if (!(persistence instanceof JdbcPersistence)) {
            System.err.println(JdbcPersistence.class.getSimpleName() + " is not being used, ignoring");
            return;
        }
        List<Class> modelClasses = Fluentness.getInstances(Repository.class)
            .stream()
            .map(Repository::getModelClass)
            .collect(Collectors.toUnmodifiableList());

        for (Class<? extends Model> modelClass : modelClasses) {
            StringBuilder builder = new StringBuilder();

            builder.append("CREATE TABLE ").append(persistence.getTableName(modelClass));

            System.out.println(builder.toString());
        }

    }
}
