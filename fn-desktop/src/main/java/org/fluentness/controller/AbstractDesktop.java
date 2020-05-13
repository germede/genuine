package org.fluentness.controller;

import org.fluentness.controller.swing.SwingView;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public abstract class AbstractDesktop implements ViewHolder<DesktopView> {

    protected SwingView window(Container container) {
        JWindow item = new JWindow();
        item.setContentPane(container);
        item.pack();
        return new SwingView(item);
    }

    protected SwingView frame(String title, Container container) {
        JFrame item = new JFrame(title);
        item.setContentPane(container);
        item.setDefaultCloseOperation(EXIT_ON_CLOSE);
        item.pack();
        return new SwingView(item);
    }

    protected SwingView dialog(Container container) {
        JDialog item = new JDialog();
        item.setContentPane(container);
        item.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        item.pack();
        return new SwingView(item);
    }

    protected JApplet applet(Container... swing) {
        return addChild(new JApplet(), swing);
    }

    protected JButton button(String text) {
        return new JButton(text);
    }

    protected AbstractButton[] buttonGroup(AbstractButton... buttons) {
        ButtonGroup buttonGroup = new ButtonGroup();
        for (AbstractButton button : buttons) {
            buttonGroup.add(button);
        }
        return buttons;
    }

    protected JCheckBox checkBox(Container... swing) {
        return addChild(new JCheckBox(), swing);
    }

    protected JCheckBoxMenuItem checkBoxMenuItem(String text) {
        return new JCheckBoxMenuItem(text);
    }

    protected JColorChooser colorChooser() {
        return new JColorChooser();
    }

    protected JComboBox comboBox(Container... swing) {
        return addChild(new JComboBox(), swing);
    }

    protected JDesktopPane desktopPane(Container... swing) {
        return addChild(new JDesktopPane(), swing);
    }

    protected JEditorPane editorPane(Container... swing) {
        return addChild(new JEditorPane(), swing);
    }

    protected JFileChooser fileChooser(Container... swing) {
        return addChild(new JFileChooser(), swing);
    }

    protected JFormattedTextField formattedTextField(Container... swing) {
        return addChild(new JFormattedTextField(), swing);
    }

    protected JInternalFrame internalFrame(Container... swing) {
        return addChild(new JInternalFrame(), swing);
    }

    protected JLabel label(Container... swing) {
        return addChild(new JLabel(), swing);
    }

    protected JLayer layer(Container... swing) {
        return addChild(new JLayer(), swing);
    }

    protected JLayeredPane layeredPane(Container... swing) {
        return addChild(new JLayeredPane(), swing);
    }

    protected JList list(Container... swing) {
        return addChild(new JList(), swing);
    }

    protected JMenu menu(String title, Container... swing) {
        return addChild(new JMenu(title), swing);
    }

    protected JMenuBar menuBar(Container... swing) {
        return addChild(new JMenuBar(), swing);
    }

    protected JMenuItem menuItem(String text) {
        return new JMenuItem(text);
    }

    protected JOptionPane optionPane(Container... swing) {
        return addChild(new JOptionPane(), swing);
    }

    protected JPanel panel(Container... swing) {
        return addChild(new JPanel(), swing);
    }

    protected JPasswordField passwordField(Container... swing) {
        return addChild(new JPasswordField(), swing);
    }

    protected JPopupMenu popupMenu(Container... swing) {
        return addChild(new JPopupMenu(), swing);
    }

    protected JProgressBar progressBar(Container... swing) {
        return addChild(new JProgressBar(), swing);
    }

    protected JRadioButton radioButton(Container... swing) {
        return addChild(new JRadioButton(), swing);
    }

    protected JRadioButtonMenuItem radioButtonMenuItem(Container... swing) {
        return addChild(new JRadioButtonMenuItem(), swing);
    }

    protected JRootPane rootPane(Container... swing) {
        return addChild(new JRootPane(), swing);
    }

    protected JScrollBar scrollBar(Container... swing) {
        return addChild(new JScrollBar(), swing);
    }

    protected JScrollPane scrollPane(Container... swing) {
        return addChild(new JScrollPane(), swing);
    }

    protected JSeparator separator(Container... swing) {
        return addChild(new JSeparator(), swing);
    }

    protected JSlider slider(Container... swing) {
        return addChild(new JSlider(), swing);
    }

    protected JSpinner spinner(Container... swing) {
        return addChild(new JSpinner(), swing);
    }

    protected JSplitPane splitPane(Container... swing) {
        return addChild(new JSplitPane(), swing);
    }

    protected JTabbedPane tabbedPane(Container... swing) {
        return addChild(new JTabbedPane(), swing);
    }

    protected JTable table(Container... swing) {
        return addChild(new JTable(), swing);
    }

    protected JTable table(String[] header, Object[]... rows) {
        return new JTable(rows, header);
    }

    protected String[] header(String... columnTitles) {
        return columnTitles;
    }

    protected Object[] row(Object... cells) {
        return cells;
    }

    protected JTextArea textArea(Container... swing) {
        return addChild(new JTextArea(), swing);
    }

    protected JTextField textField(Container... swing) {
        return addChild(new JTextField(), swing);
    }

    protected JTextPane textPane(Container... swing) {
        return addChild(new JTextPane(), swing);
    }

    protected JToggleButton toggleButton(Container... swing) {
        return addChild(new JToggleButton(), swing);
    }

    protected JToolBar toolBar(Container... swing) {
        return addChild(new JToolBar(), swing);
    }

    protected JToolTip toolTip(Container... swing) {
        return addChild(new JToolTip(), swing);
    }

    protected JTree tree(Container... swing) {
        return addChild(new JTree(), swing);
    }

    protected JViewport viewport(Container... swing) {
        return addChild(new JViewport(), swing);
    }

    private <C extends Container> C addChild(C container, Container[] containers) {
        for (Container swing : containers) {
            container.add(swing);
        }
        return container;
    }

}
