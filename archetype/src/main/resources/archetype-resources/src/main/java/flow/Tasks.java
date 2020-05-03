package ${package}.flow;

import org.fluentness.mobile.console.Task;
import org.fluentness.mobile.console.TaskProducer;

public class Tasks extends TaskProducer {

    Task dummy = does("Nothing useful",
        arguments -> {
            System.out.println("Dummy");
        }
    );

}
