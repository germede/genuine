package org.fluentness.controller;

import org.fluentness.view.AbstractDesktopView;
import org.fluentness.view.swing.Swing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractDesktopController<V extends AbstractDesktopView> implements Controller {

    private final V view;

    public AbstractDesktopController(V view) {
        this.view = view;
    }

    public V getView() {
        return view;
    }

    @Override
    public final Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {

        String selector();

        Event event() default Event.CLICK;

    }

    public void setListeners() {
        for (Method action : getActions()) {
            Action annotation = action.getAnnotation(Action.class);
            // todo support hierarchy
            // todo remove dependency on Swing
            // todo dont use static getBYId implement own methods on DesktopView
            String selector = annotation.selector();
            if (selector.startsWith("#")) {
                Swing byId = Swing.getById(selector.replace("#", ""));
                if(byId != null) {
                    Container actualSwing = byId.getView();
                    switch (annotation.event()) {
                        case CLICK:
                            actualSwing.addMouseListener(new MouseListener() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    try {
                                        action.setAccessible(true);
                                        action.invoke(AbstractDesktopController.this);
                                    } catch (IllegalAccessException | InvocationTargetException ex) {
                                        ex.printStackTrace();
                                    }
                                }

                                @Override
                                public void mousePressed(MouseEvent e) {

                                }

                                @Override
                                public void mouseReleased(MouseEvent e) {

                                }

                                @Override
                                public void mouseEntered(MouseEvent e) {

                                }

                                @Override
                                public void mouseExited(MouseEvent e) {

                                }
                            });
                    }

                }

            }
        }
    }

    protected enum Event {
        CLICK;
    }
}
