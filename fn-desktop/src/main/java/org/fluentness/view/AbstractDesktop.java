package org.fluentness.view;

import org.fluentness.view.swing.SwingTemplate;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public abstract class AbstractDesktop extends AbstractPrerenderedView<DesktopTemplate> {


    protected static SwingTemplate window(Container container) {
        JWindow item = new JWindow();
        item.setContentPane(container);
        item.pack();
        return new SwingTemplate(item);
    }

    protected static SwingTemplate frame(String title, Container container) {
        JFrame item = new JFrame(title);
        item.setContentPane(container);
        item.setDefaultCloseOperation(EXIT_ON_CLOSE);
        item.pack();
        return new SwingTemplate(item);
    }

    protected static SwingTemplate dialog(Container container) {
        JDialog item = new JDialog();
        item.setContentPane(container);
        item.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        item.pack();
        return new SwingTemplate(item);
    }

    protected static JApplet applet(Container... swing) {
        return addChild(new JApplet(), swing);
    }

    protected static JButton button(String text) {
        return new JButton(text);
    }

    protected static AbstractButton[] buttonGroup(AbstractButton... buttons) {
        ButtonGroup buttonGroup = new ButtonGroup();
        for (AbstractButton button : buttons) {
            buttonGroup.add(button);
        }
        return buttons;
    }

    protected static JCheckBox checkBox(Container... swing) {
        return addChild(new JCheckBox(), swing);
    }

    protected static JCheckBoxMenuItem checkBoxMenuItem(String text) {
        return new JCheckBoxMenuItem(text);
    }

    protected static JColorChooser colorChooser() {
        return new JColorChooser();
    }

    protected static JComboBox comboBox(Container... swing) {
        return addChild(new JComboBox(), swing);
    }

    protected static JDesktopPane desktopPane(Container... swing) {
        return addChild(new JDesktopPane(), swing);
    }

    protected static JEditorPane editorPane(Container... swing) {
        return addChild(new JEditorPane(), swing);
    }

    protected static JFileChooser fileChooser(Container... swing) {
        return addChild(new JFileChooser(), swing);
    }

    protected static JFormattedTextField formattedTextField(Container... swing) {
        return addChild(new JFormattedTextField(), swing);
    }

    protected static JInternalFrame internalFrame(Container... swing) {
        return addChild(new JInternalFrame(), swing);
    }

    protected static JLabel label(Container... swing) {
        return addChild(new JLabel(), swing);
    }

    protected static JLayer layer(Container... swing) {
        return addChild(new JLayer(), swing);
    }

    protected static JLayeredPane layeredPane(Container... swing) {
        return addChild(new JLayeredPane(), swing);
    }

    protected static JList list(Container... swing) {
        return addChild(new JList(), swing);
    }

    protected static JMenu menu(String title, Container... swing) {
        return addChild(new JMenu(title), swing);
    }

    protected static JMenuBar menuBar(Container... swing) {
        return addChild(new JMenuBar(), swing);
    }

    protected static JMenuItem menuItem(String text) {
        return new JMenuItem(text);
    }

    protected static JOptionPane optionPane(Container... swing) {
        return addChild(new JOptionPane(), swing);
    }

    protected static JPanel panel(Container... swing) {
        return addChild(new JPanel(), swing);
    }

    protected static JPasswordField passwordField(Container... swing) {
        return addChild(new JPasswordField(), swing);
    }

    protected static JPopupMenu popupMenu(Container... swing) {
        return addChild(new JPopupMenu(), swing);
    }

    protected static JProgressBar progressBar(Container... swing) {
        return addChild(new JProgressBar(), swing);
    }

    protected static JRadioButton radioButton(Container... swing) {
        return addChild(new JRadioButton(), swing);
    }

    protected static JRadioButtonMenuItem radioButtonMenuItem(Container... swing) {
        return addChild(new JRadioButtonMenuItem(), swing);
    }

    protected static JRootPane rootPane(Container... swing) {
        return addChild(new JRootPane(), swing);
    }

    protected static JScrollBar scrollBar(Container... swing) {
        return addChild(new JScrollBar(), swing);
    }

    protected static JScrollPane scrollPane(Container... swing) {
        return addChild(new JScrollPane(), swing);
    }

    protected static JSeparator separator(Container... swing) {
        return addChild(new JSeparator(), swing);
    }

    protected static JSlider slider(Container... swing) {
        return addChild(new JSlider(), swing);
    }

    protected static JSpinner spinner(Container... swing) {
        return addChild(new JSpinner(), swing);
    }

    protected static JSplitPane splitPane(Container... swing) {
        return addChild(new JSplitPane(), swing);
    }

    protected static JTabbedPane tabbedPane(Container... swing) {
        return addChild(new JTabbedPane(), swing);
    }

    protected static JTable table(Container... swing) {
        return addChild(new JTable(), swing);
    }

    protected static JTable table(String[] header, Object[]... rows) {
        return new JTable(rows, header);
    }

    protected static String[] header(String... columnTitles) {
        return columnTitles;
    }

    protected static Object[] row(Object... cells) {
        return cells;
    }

    protected static JTextArea textArea(Container... swing) {
        return addChild(new JTextArea(), swing);
    }

    protected static JTextField textField(Container... swing) {
        return addChild(new JTextField(), swing);
    }

    protected static JTextPane textPane(Container... swing) {
        return addChild(new JTextPane(), swing);
    }

    protected static JToggleButton toggleButton(Container... swing) {
        return addChild(new JToggleButton(), swing);
    }

    protected static JToolBar toolBar(Container... swing) {
        return addChild(new JToolBar(), swing);
    }

    protected static JToolTip toolTip(Container... swing) {
        return addChild(new JToolTip(), swing);
    }

    protected static JTree tree(Container... swing) {
        return addChild(new JTree(), swing);
    }

    protected static JViewport viewport(Container... swing) {
        return addChild(new JViewport(), swing);
    }

    private static <C extends Container> C addChild(C container, Container[] containers) {
        for (Container swing : containers) {
            container.add(swing);
        }
        return container;
    }

}
