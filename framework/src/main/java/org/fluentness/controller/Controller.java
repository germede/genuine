package org.fluentness.controller;

import org.fluentness.ApplicationComponent;

import java.lang.reflect.Method;
import java.util.List;

public interface Controller<A extends Controller.Action> extends ApplicationComponent {
    List<A> getActions();

    interface Action {
        Method getMethod();
    }
}
