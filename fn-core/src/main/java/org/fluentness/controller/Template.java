package org.fluentness.controller;

public interface Template<V extends View> {

    V render();

}
