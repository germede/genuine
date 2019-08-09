package org.fluentness.flow.controller.task;

import org.fluentness.flow.controller.AnsiColor;

public interface TaskFactory extends AnsiColor {

    default Task does(String description, TaskExecutable executable) {
        return new Task(description, executable);
    }
}
