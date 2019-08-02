package org.fluentness.flow.component.task;

import org.fluentness.base.common.constant.AnsiColor;

public interface TaskFactory extends AnsiColor {

    default Task does(String description, TaskExecutable executable) {
        return new Task(description, executable);
    }
}
