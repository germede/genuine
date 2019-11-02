package org.fluentness.controller;

import java.lang.reflect.Method;
import java.util.List;

public interface Controller<A extends Controller.Action> {
    List<A> getActions();

    interface Action {
        Method getMethod();
    }
}
