package ${package}.flow;

import org.fluentness.flow.task.Task;
import org.fluentness.flow.task.TaskProvider;

public class Tasks extends TaskProvider {

    Task dummy = does("Nothing useful",
        arguments -> {
            System.out.println("Dummy");
        }
    );

}
