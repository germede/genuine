package org.fluentness.flow.component.task;

import org.fluentness.base.common.constant.AnsiColors;

public interface TaskFactory extends AnsiColors {

    default Task does(String description, TaskExecutable executable, String... args) {
        return new Task(description, executable, args);
    }
}
