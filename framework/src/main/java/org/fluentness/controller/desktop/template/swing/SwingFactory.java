package org.fluentness.controller.desktop.template.swing;

import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public final class SwingFactory {

    // ==== windows

    public static Swing<JWindow> window(Swing content) {
        JWindow item = new JWindow();
        item.setContentPane(content.getActualSwing());
        item.pack();
        return new Swing<>(item);
    }

    public static Swing<JFrame> frame(String title, Swing content) {
        JFrame item = new JFrame(title);
        item.setContentPane(content.getActualSwing());
        item.setDefaultCloseOperation(EXIT_ON_CLOSE);
        item.pack();
        return new Swing(item);
    }

    public static Swing<JDialog> dialog(Swing content) {
        JDialog item = new JDialog();
        item.setContentPane(content.getActualSwing());
        item.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        item.pack();
        return new Swing(item);
    }

    // ==== component

    public static Swing<JPanel> panel(Swing... Swings) {
        JPanel item = new JPanel();
        for (Swing Swing : Swings) {
            item.add(Swing.getActualSwing());
        }
        return new Swing(item);
    }

    public static Swing<JLabel> label(String text) {
        JLabel item = new JLabel(text);
        return new Swing(item);
    }

    public static Swing<JMenuBar> menuBar(Swing<JMenu>... menus) {
        JMenuBar item = new JMenuBar();
        for (Swing<JMenu> menu : menus) {
            item.add(menu.getActualSwing());
        }
        return new Swing(item);
    }

    public static Swing<JColorChooser> colorChooser() {
        JColorChooser item = new JColorChooser();
        return new Swing(item);
    }

    public static Swing<JPopupMenu> popupMenu(Swing<JMenuItem>... menuItems) {
        JPopupMenu item = new JPopupMenu();
        for (Swing<JMenuItem> menuItem : menuItems) {
            item.add(menuItem.getActualSwing());
        }
        return new Swing<>(item);
    }


    // ======== table

    public static Swing<JTable> table(String[] header, Object[]... rows) {
        JTable item = new JTable(rows, header);
        return new Swing<>(item);
    }

    public static String[] header(String... columnTitles) {
        return columnTitles;
    }

    public static Object[] row(Object... cells) {
        return cells;
    }

    // ======== button

    public static Swing<JButton> button(String text) {
        JButton item = new JButton(text);
        return new Swing<>(item);
    }

    public static Swing<AbstractButton>[] buttonGroup(Swing<AbstractButton>... buttons) {
        ButtonGroup buttonGroup = new ButtonGroup();
        for (Swing<AbstractButton> button : buttons) {
            buttonGroup.add(button.getActualSwing());
        }
        return buttons;
    }

    // ============ menu

    public static Swing<JMenu> menu(String text, Swing<? extends JMenuItem>... menuItems) {
        JMenu item = new JMenu(text);
        for (Swing<? extends JMenuItem> menuItem : menuItems) {
            item.add(menuItem.getActualSwing());
        }
        return new Swing(item);
    }

    public static Swing<JMenuItem> menuItem(String text) {
        JMenuItem item = new JMenuItem(text);
        return new Swing(item);
    }

    public static Swing<JRadioButtonMenuItem> radioButtonMenuItem(String text) {
        JRadioButtonMenuItem item = new JRadioButtonMenuItem(text);
        return new Swing(item);
    }

    public static Swing<JCheckBoxMenuItem> checkBoxMenuItem(String text) {
        JCheckBoxMenuItem item = new JCheckBoxMenuItem(text);
        return new Swing(item);
    }

    // ============ toggle

    public static Swing<JToggleButton> toggleButton(String text) {
        JToggleButton item = new JToggleButton(text);
        return new Swing(item);
    }

    public static Swing<JRadioButton> radioButton(String text) {
        JRadioButton item = new JRadioButton(text);
        return new Swing(item);
    }

    public static Swing<JCheckBox> checkBox(String text) {
        JCheckBox item = new JCheckBox(text);
        return new Swing(item);
    }

    // ======== text

    public static Swing<JTextArea> textArea() {
        JTextArea item = new JTextArea();
        return new Swing(item);
    }

    private SwingFactory() {
    }
}
