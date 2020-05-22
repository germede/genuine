package org.fluentness.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.*;

import static org.fluentness.service.log.AnsiColor.*;
import static org.fluentness.service.log.AnsiColor.RESET;

public abstract class AbstractConsoleController implements Controller {

    public Method[] getActions() {
        return Arrays.stream(this.getClass().getMethods())
            .filter(method -> method.isAnnotationPresent(Action.class))
            .toArray(Method[]::new);
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {
        String description() default "";

        String category() default "";
    }


    @Action(description = "Prints all available console actions")
    public void help() {

        System.out.println("\n"
                + " _______                                \n"
                + "(  /  //             _/_                \n"
                + " -/--// , , _  _ _   /  _ _   _  (   (  \n"
                + "_/  (/_(_/_(/_/ / /_(__/ / /_(/_/_)_/_)_\n"
        );

        System.out.println(GREEN + "Available console actions:" + RESET);

        Map<String, List<String>> categorizedConsoleActions = new TreeMap<>();

        // categorize console actions
        for (Method action : getActions()) {
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
    public void convert() {
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
//
//        JFrame frame = new JFrame();
//        JTextPane input = new JTextPane();
//        JButton button = new JButton("Convert");
//
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setPreferredSize(new Dimension(1000, 300));
//
//        ScrollPane inputScroll = new ScrollPane();
//        inputScroll.add(input);
//
//        frame.setLayout(new BorderLayout());
//        frame.add(inputScroll, BorderLayout.CENTER);
//        frame.add(button, BorderLayout.SOUTH);
//
//        frame.pack();
//        frame.setVisible(true);
//
//        button.addActionListener(e -> {
//            final Pattern TAG_PATTERN = Pattern.compile("<(?!!)(?!/)\\s*([a-zA-Z0-9]+)(.*?)>(.+)<");
//            final Pattern ATTRIBUTE_PATTERN = Pattern.compile("(\\S+)=['\"]{1}([^>]*?)['\"]{1}");
//
//            String text = input.getText().replaceAll("<(\\w+)\\s", "$1(");
//            text = text.replaceAll("\\s(\\w+)=\"([\\w\\s]+)\"", "$1 + \"$2\", ");
//            text = text.replaceAll("</\\w*>", "),");
//            text = text.replaceAll(">", "");
//            // todo improve
//
//            input.setText(text);
//        });
    }

    @Action(category = "sql", description = "Prints out required create sql statements based on existing Models")
    public void schema() {
//        Persistence persistence = Fluentness.getInstance(Persistence.class);
//        if (!(persistence instanceof JdbcPersistence)) {
//            System.err.println(JdbcPersistence.class.getSimpleName() + " is not being used, ignoring");
//            return;
//        }
//        List<Class> modelClasses = Fluentness.getInstances(AbstractCrudRepository.class)
//            .stream()
//            .map(AbstractCrudRepository::getModelClass)
//            .collect(Collectors.toList());
//
//        StringBuilder builder = new StringBuilder();
//        for (Class<? extends CrudModel> modelClass : modelClasses) {
//
//            // todo improve sorting depending on foreign
//            List<Field> foreignKeys = new LinkedList<>();
//
//            builder.append("CREATE TABLE ").append(persistence.getTableName(modelClass)).append(" ( \n");
//            builder.append("    ").append(CrudModel.ID_NAME).append(" INT AUTO_INCREMENT PRIMARY KEY,\n");
//            Field[] declaredFields = modelClass.getDeclaredFields();
//            for (int i = 0, declaredFieldsLength = declaredFields.length; i < declaredFieldsLength; i++) {
//                Field field = declaredFields[i];
//                builder.append("    ").append(field.getName()).append(" ");
//                Class<?> type = field.getType();
//                if (type.equals(String.class)) {
//                    builder.append("VARCHAR(255) NOT NULL");
//                } else if (int.class.isAssignableFrom(type)) {
//                    builder.append("INT NOT NULL");
//                } else if (CrudModel.class.isAssignableFrom(type)) {
//                    builder.append("INT NOT NULL");
//                    foreignKeys.add(field);
//                }
//                builder.append(i == declaredFieldsLength - 1 && foreignKeys.isEmpty() ? "\n" : ",\n");
//            }
//
//            for (int i = 0, foreignKeysSize = foreignKeys.size(); i < foreignKeysSize; i++) {
//                Field field = foreignKeys.get(i);
//                builder
//                    .append("    FOREIGN KEY (")
//                    .append(field.getName())
//                    .append(") REFERENCES ")
//                    .append(persistence.getTableName((Class<? extends CrudModel>) field.getType()))
//                    .append("(")
//                    .append(CrudModel.ID_NAME)
//                    .append(") ON UPDATE cascade ")
//                    .append("ON DELETE cascade")
//                    .append(i == foreignKeysSize - 1 ? "\n" : ",\n");
//            }
//            builder.append(");\n");
//        }
//        System.out.println(builder.toString());
    }


}
