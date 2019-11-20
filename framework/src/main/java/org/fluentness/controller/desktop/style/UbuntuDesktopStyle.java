package org.fluentness.controller.desktop.style;

import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class UbuntuDesktopStyle extends DesktopStyle {

    protected static final Color BACKGROUND = new Color(245, 246, 247);
    protected static final Color ORANGE = new Color(237, 78, 0);
    protected static final Color GRAY = new Color(182, 186, 187);
    protected static final Dimension MENU_ITEM_SIZE = new Dimension(100, 30);
    protected static final Border ACTIVE_BORDER = BorderFactory.createCompoundBorder(
        BorderFactory.createMatteBorder(0, 0, 2, 0, ORANGE),
        BorderFactory.createEmptyBorder(6, 5, 2, 5)
    );
    protected static final Border INACTIVE_BORDER = BorderFactory.createEmptyBorder(6, 5, 4, 5);
    protected static final Font UBUNTU_FONT = new Font("Ubuntu", Font.PLAIN, 14);

    UbuntuDesktopStyle() {
        super(new GTKLookAndFeel());
        panel();
        menuItem();
        menu();
        menuBar();
    }

    private void panel() {
        set(JPanel.class, jPanel -> {
            Color background = jPanel.getBackground();
        });
    }

    private void menuItem() {
        set(JMenuItem.class, view -> {
            view.setOpaque(true);
            view.setMnemonic(view.getText().isEmpty() ? 0 : view.getText().charAt(0));
            view.setFont(UBUNTU_FONT);
        });
    }

    private void menu() {
        set(JMenu.class, view -> {
            view.setBackground(BACKGROUND);
            view.setBorder(INACTIVE_BORDER);
            view.addMenuListener(new MenuListener() {
                @Override
                public void menuSelected(MenuEvent menuEvent) {
                    view.setBorder(ACTIVE_BORDER);
                    view.setBackground(BACKGROUND);
                }

                @Override
                public void menuDeselected(MenuEvent menuEvent) {
                    view.setBorder(INACTIVE_BORDER);
                }

                @Override
                public void menuCanceled(MenuEvent menuEvent) {
                    view.setBorder(INACTIVE_BORDER);
                }
            });

            view.setBorderPainted(true);
            view.setMnemonic(view.getText().isEmpty() ? 0 : view.getText().charAt(0));
        });
    }

    private void menuBar() {
        set(JMenuBar.class, view -> {
            view.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
            view.setBackground(BACKGROUND);
        });
    }
}
