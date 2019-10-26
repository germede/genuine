package org.fluentness.controller;

import java.lang.reflect.Method;

public interface Controller {

    Method[] getActions();
}
