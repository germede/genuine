package org.fluentness.controller.desktop.view;

import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.util.Locale;
import java.util.Set;

public abstract class AbstractSwingView<Self extends AbstractSwingView, View extends Container> extends DesktopView {

    protected View view;

    protected AbstractSwingView(View view) {
        super(view);
        this.view = view;
    }

    @Override
    public Boolean render() {
        view.setVisible(true);
        return true;
    }

    public View getView() {
        return view;
    }

    // ==== instead of layout()
    public Self borderLayout(String... arrangements) {
        view.setLayout(new BorderLayout());
        Component[] components = view.getComponents();
        view.removeAll();
        for (int i = 0; i < components.length && i < arrangements.length; i++) {
            view.add(components[i], arrangements[i]);
        }
        return (Self) this;
    }

    public Self boxLayout(int align) {
        view.setLayout(new BoxLayout(view, align));
        Component[] components = view.getComponents();
        view.removeAll();
        for (Component component : components) {
            view.add(component, Component.CENTER_ALIGNMENT);
        }
        return (Self) this;
    }

    public Self flowLayout() {
        view.setLayout(new FlowLayout());
        return (Self) this;
    }


    // ==== from java.awt.Component
    public Self componentListener(ComponentListener l) {
        view.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {

            }

            @Override
            public void componentMoved(ComponentEvent componentEvent) {

            }

            @Override
            public void componentShown(ComponentEvent componentEvent) {

            }

            @Override
            public void componentHidden(ComponentEvent componentEvent) {

            }
        });
        return (Self) this;
    }

    public Self focusListener(FocusListener l) {
        view.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {

            }

            @Override
            public void focusLost(FocusEvent focusEvent) {

            }
        });
        return (Self) this;
    }

    public Self hierarchyBoundsListener(HierarchyBoundsListener l) {
        view.addHierarchyBoundsListener(new HierarchyBoundsListener() {
            @Override
            public void ancestorMoved(HierarchyEvent hierarchyEvent) {

            }

            @Override
            public void ancestorResized(HierarchyEvent hierarchyEvent) {

            }
        });
        return (Self) this;
    }

    public Self hierarchyListener(HierarchyListener l) {
        view.addHierarchyListener(l);
        return (Self) this;
    }

    public Self inputMethodListener(InputMethodListener l) {
        view.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent inputMethodEvent) {

            }

            @Override
            public void caretPositionChanged(InputMethodEvent inputMethodEvent) {

            }
        });
        return (Self) this;
    }

    public Self keyListener(KeyListener l) {
        view.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }

            @Override
            public void keyPressed(KeyEvent keyEvent) {

            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
        });
        return (Self) this;
    }

    public Self mouseListener(MouseListener l) {
        view.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        });
        return (Self) this;
    }

    public Self mouseMotionListener(MouseMotionListener l) {
        view.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {

            }
        });
        return (Self) this;
    }

    public Self mouseWheelListener(MouseWheelListener l) {
        view.addMouseWheelListener(l);
        return (Self) this;
    }

    public Self background(Color c) {
        view.setBackground(c);
        return (Self) this;
    }

    public Self bounds(int x, int y, int width, int height) {
        view.setBounds(x, y, width, height);
        return (Self) this;
    }

    public Self bounds(Rectangle r) {
        view.setBounds(r);
        return (Self) this;
    }

    public Self componentOrientation(ComponentOrientation o) {
        view.setComponentOrientation(o);
        return (Self) this;
    }

    public Self cursor(Cursor cursor) {
        view.setCursor(cursor);
        return (Self) this;
    }

    public Self dropTarget(DropTarget dt) {
        view.setDropTarget(dt);
        return (Self) this;
    }

    public Self enabled(boolean b) {
        view.setEnabled(b);
        return (Self) this;
    }

    public Self focusable(boolean focusable) {
        view.setFocusable(focusable);
        return (Self) this;
    }

    public Self focusTraversalKeysEnabled(boolean focusTraversalKeysEnabled) {
        view.setFocusTraversalKeysEnabled(focusTraversalKeysEnabled);
        return (Self) this;
    }

    public Self foreground(Color c) {
        view.setForeground(c);
        return (Self) this;
    }

    public Self ignoreRepaint(boolean ignoreRepaint) {
        view.setIgnoreRepaint(ignoreRepaint);
        return (Self) this;
    }

    public Self locale(Locale l) {
        view.setLocale(l);
        return (Self) this;
    }

    public Self location(int x, int y) {
        view.setLocation(x, y);
        return (Self) this;
    }

    public Self maximumSize(int x, int y) {
        view.setMaximumSize(new Dimension(x, y));
        return (Self) this;
    }

    public Self minimumSize(int x, int y) {
        view.setMinimumSize(new Dimension(x, y));
        return (Self) this;
    }

    public Self name(String name) {
        SwingViewRegistry.add(name, view);
        view.setName(name);
        return (Self) this;
    }

    public Self preferredSize(int x, int y) {
        view.setPreferredSize(new Dimension(x, y));
        return (Self) this;
    }

    public Self size(int width, int height) {
        view.setSize(width, height);
        return (Self) this;
    }


    // ==== from java.awt.Container
    public Self containerListener(ContainerListener l) {
        view.addContainerListener(l);
        return (Self) this;
    }

    public Self propertyChangeListener(PropertyChangeListener listener) {
        view.addPropertyChangeListener(listener);
        return (Self) this;
    }

    public Self propertyChangeListener(String propertyName, PropertyChangeListener listener) {
        view.addPropertyChangeListener(propertyName, listener);
        return (Self) this;
    }

    public Self componentZOrder(Component comp, int index) {
        view.setComponentZOrder(comp, index);
        return (Self) this;
    }

    public Self focusCycleRoot(boolean focusCycleRoot) {
        view.setFocusCycleRoot(focusCycleRoot);
        return (Self) this;
    }

    public Self focusTraversalKeys(int id, Set<? extends AWTKeyStroke> keystrokes) {
        view.setFocusTraversalKeys(id, keystrokes);
        return (Self) this;
    }

    public Self focusTraversalPolicy(FocusTraversalPolicy policy) {
        view.setFocusTraversalPolicy(policy);
        return (Self) this;
    }

    public Self focusTraversalPolicyProvider(boolean provider) {
        view.setFocusTraversalPolicyProvider(provider);
        return (Self) this;
    }

    public Self font(Font f) {
        view.setFont(f);
        return (Self) this;
    }

    public Self layout(LayoutManager mgr) {
        view.setLayout(mgr);
        return (Self) this;
    }
}
