package ${package}.flow;

import org.fluentness.controller.console.Task;
import org.fluentness.controller.console.TaskProducer;

public class Tasks extends TaskProducer {

    Task dummy = does("Nothing useful",
        arguments -> {
            System.out.println("Dummy");
        }
    );

}
