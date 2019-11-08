package org.fluentness.controller.desktop.swing;

import org.fluentness.controller.desktop.DesktopView;

import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.Locale;
import java.util.Set;

public abstract class AbstractSwingView<Self extends AbstractSwingView, View extends Container> implements DesktopView {

    public abstract View getSwingView();

    @Override
    public void render() {
        getSwingView().setVisible(true);
    }

    // ==== from java.awt.Component
    public Self componentListener(ComponentListener l) {
        getSwingView().addComponentListener(l);
        return (Self) this;
    }

    public Self focusListener(FocusListener l) {
        getSwingView().addFocusListener(l);
        return (Self) this;
    }

    public Self hierarchyBoundsListener(HierarchyBoundsListener l) {
        getSwingView().addHierarchyBoundsListener(l);
        return (Self) this;
    }

    public Self hierarchyListener(HierarchyListener l) {
        getSwingView().addHierarchyListener(l);
        return (Self) this;
    }

    public Self inputMethodListener(InputMethodListener l) {
        getSwingView().addInputMethodListener(l);
        return (Self) this;
    }

    public Self keyListener(KeyListener l) {
        getSwingView().addKeyListener(l);
        return (Self) this;
    }

    public Self mouseListener(MouseListener l) {
        getSwingView().addMouseListener(l);
        return (Self) this;
    }

    public Self mouseMotionListener(MouseMotionListener l) {
        getSwingView().addMouseMotionListener(l);
        return (Self) this;
    }

    public Self mouseWheelListener(MouseWheelListener l) {
        getSwingView().addMouseWheelListener(l);
        return (Self) this;
    }

    public Self background(Color c) {
        getSwingView().setBackground(c);
        return (Self) this;
    }

    public Self bounds(int x, int y, int width, int height) {
        getSwingView().setBounds(x, y, width, height);
        return (Self) this;
    }

    public Self bounds(Rectangle r) {
        getSwingView().setBounds(r);
        return (Self) this;
    }

    public Self componentOrientation(ComponentOrientation o) {
        getSwingView().setComponentOrientation(o);
        return (Self) this;
    }

    public Self cursor(Cursor cursor) {
        getSwingView().setCursor(cursor);
        return (Self) this;
    }

    public Self dropTarget(DropTarget dt) {
        getSwingView().setDropTarget(dt);
        return (Self) this;
    }

    public Self enabled(boolean b) {
        getSwingView().setEnabled(b);
        return (Self) this;
    }

    public Self focusable(boolean focusable) {
        getSwingView().setFocusable(focusable);
        return (Self) this;
    }

    public Self focusTraversalKeysEnabled(boolean focusTraversalKeysEnabled) {
        getSwingView().setFocusTraversalKeysEnabled(focusTraversalKeysEnabled);
        return (Self) this;
    }

    public Self foreground(Color c) {
        getSwingView().setForeground(c);
        return (Self) this;
    }

    public Self ignoreRepaint(boolean ignoreRepaint) {
        getSwingView().setIgnoreRepaint(ignoreRepaint);
        return (Self) this;
    }

    public Self locale(Locale l) {
        getSwingView().setLocale(l);
        return (Self) this;
    }

    public Self location(int x, int y) {
        getSwingView().setLocation(x, y);
        return (Self) this;
    }

    public Self location(Point p) {
        getSwingView().setLocation(p);
        return (Self) this;
    }

    public Self maximumSize(Dimension maximumSize) {
        getSwingView().setMaximumSize(maximumSize);
        return (Self) this;
    }

    public Self minimumSize(Dimension minimumSize) {
        getSwingView().setMinimumSize(minimumSize);
        return (Self) this;
    }

    public Self name(String name) {
        SwingViewRegistry.add(name, getSwingView());
        getSwingView().setName(name);
        return (Self) this;
    }

    public Self preferredSize(Dimension preferredSize) {
        getSwingView().setPreferredSize(preferredSize);
        return (Self) this;
    }

    public Self size(Dimension d) {
        getSwingView().setSize(d);
        return (Self) this;
    }

    public Self size(int width, int height) {
        getSwingView().setSize(width, height);
        return (Self) this;
    }


    // ==== from java.awt.Container
    public Self containerListener(ContainerListener l) {
        getSwingView().addContainerListener(l);
        return (Self) this;
    }

    public Self propertyChangeListener(PropertyChangeListener listener) {
        getSwingView().addPropertyChangeListener(listener);
        return (Self) this;
    }

    public Self propertyChangeListener(String propertyName, PropertyChangeListener listener) {
        getSwingView().addPropertyChangeListener(propertyName, listener);
        return (Self) this;
    }

    public Self componentZOrder(Component comp, int index) {
        getSwingView().setComponentZOrder(comp, index);
        return (Self) this;
    }

    public Self focusCycleRoot(boolean focusCycleRoot) {
        getSwingView().setFocusCycleRoot(focusCycleRoot);
        return (Self) this;
    }

    public Self focusTraversalKeys(int id, Set<? extends AWTKeyStroke> keystrokes) {
        getSwingView().setFocusTraversalKeys(id, keystrokes);
        return (Self) this;
    }

    public Self focusTraversalPolicy(FocusTraversalPolicy policy) {
        getSwingView().setFocusTraversalPolicy(policy);
        return (Self) this;
    }

    public Self focusTraversalPolicyProvider(boolean provider) {
        getSwingView().setFocusTraversalPolicyProvider(provider);
        return (Self) this;
    }

    public Self font(Font f) {
        getSwingView().setFont(f);
        return (Self) this;
    }

    public Self layout(LayoutManager mgr) {
        getSwingView().setLayout(mgr);
        return (Self) this;
    }
}
