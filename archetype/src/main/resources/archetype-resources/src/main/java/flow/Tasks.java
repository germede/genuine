package ${package}.flow;

import org.fluentness.flow.component.task.Task;
import org.fluentness.flow.component.task.TaskProducer;

public class Tasks extends TaskProducer {

    Task dummy = does("Nothing useful",
        arguments -> {
            System.out.println("Dummy");
        }
    );

}
