package ${package}.flow;

import org.fluentness.flow.controller.task.Task;
import org.fluentness.flow.controller.task.TaskProducer;

public class Tasks extends TaskProducer {

    Task dummy = does("Nothing useful",
        arguments -> {
            System.out.println("Dummy");
        }
    );

}
