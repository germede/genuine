package org.fluentness.controller;

import org.fluentness.ApplicationComponent;

import java.util.List;

public interface Controller<A extends Action, V extends View> extends ApplicationComponent {

    List<A> getActions();

}
