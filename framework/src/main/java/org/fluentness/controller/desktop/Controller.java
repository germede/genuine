package org.fluentness.controller.desktop;

import org.fluentness.controller.desktop.template.swing.Swing;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Controller<D extends View> implements org.fluentness.controller.Controller {

    protected final D desktop;

    public Controller() {
        D desktop = null;
        try {
            desktop = ((Class<D>) Class.forName(getClass().getCanonicalName().replace("Controller", ""))).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            System.exit(1);
        }
        this.desktop = desktop;
    }

    public void setListeners() {
        for (Method action : getActions()) {
            Action annotation = action.getAnnotation(Action.class);
            // todo support hierarchy
            // todo remove dependency on Swing
            String selector = annotation.selector();
            if (selector.startsWith("#")) {
                Swing byId = Swing.getById(selector.replace("#", ""));
                if(byId != null) {
                    Container actualSwing = byId.getActualSwing();
                    switch (annotation.event()) {
                        case CLICK:
                            actualSwing.addMouseListener(new MouseListener() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    try {
                                        action.setAccessible(true);
                                        action.invoke(Controller.this);
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

    public final D getDesktop() {
        return desktop;
    }

    @Override
    public Class<? extends Annotation> getActionClass() {
        return Action.class;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    protected @interface Action {

        String selector();

        Event event() default Event.CLICK;

    }

    protected enum Event {
        CLICK
    }
}
