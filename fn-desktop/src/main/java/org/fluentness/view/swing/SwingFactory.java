package org.fluentness.view.swing;

import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public final class SwingFactory {

    public static SwingTemplate window(Swing content) {
        JWindow item = new JWindow();
        item.setContentPane(content.getView());
        item.pack();
        return new SwingTemplate(item, content);
    }

    public static SwingTemplate frame(String title, Swing content) {
        JFrame item = new JFrame(title);
        item.setContentPane(content.getView());
        item.setDefaultCloseOperation(EXIT_ON_CLOSE);
        item.pack();
        return new SwingTemplate(item, content);
    }

    public static SwingTemplate dialog(Swing content) {
        JDialog item = new JDialog();
        item.setContentPane(content.getView());
        item.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        item.pack();
        return new SwingTemplate(item, content);
    }

    public static Swing applet(CharSequence... swing) {
        return new Swing(new JApplet(), swing);
    }

    public static Swing button(CharSequence... swing) {
        return new Swing(new JButton(), swing);
    }

    public static Swing checkBox(CharSequence... swing) {
        return new Swing(new JCheckBox(), swing);
    }

    public static Swing checkBoxMenuItem(CharSequence... swing) {
        return new Swing(new JCheckBoxMenuItem(), swing);
    }

    public static Swing colorChooser(CharSequence... swing) {
        return new Swing(new JColorChooser(), swing);
    }

    public static Swing comboBox(CharSequence... swing) {
        return new Swing(new JComboBox(), swing);
    }

    public static Swing desktopPane(CharSequence... swing) {
        return new Swing(new JDesktopPane(), swing);
    }

    public static Swing editorPane(CharSequence... swing) {
        return new Swing(new JEditorPane(), swing);
    }

    public static Swing fileChooser(CharSequence... swing) {
        return new Swing(new JFileChooser(), swing);
    }

    public static Swing formattedTextField(CharSequence... swing) {
        return new Swing(new JFormattedTextField(), swing);
    }

    public static Swing internalFrame(CharSequence... swing) {
        return new Swing(new JInternalFrame(), swing);
    }

    public static Swing label(CharSequence... swing) {
        return new Swing(new JLabel(), swing);
    }

    public static Swing layer(CharSequence... swing) {
        return new Swing(new JLayer(), swing);
    }

    public static Swing layeredPane(CharSequence... swing) {
        return new Swing(new JLayeredPane(), swing);
    }

    public static Swing list(CharSequence... swing) {
        return new Swing(new JList(), swing);
    }

    public static Swing menu(CharSequence... swing) {
        return new Swing(new JMenu(), swing);
    }

    public static Swing menuBar(CharSequence... swing) {
        return new Swing(new JMenuBar(), swing);
    }

    public static Swing menuItem(CharSequence... swing) {
        return new Swing(new JMenuItem(), swing);
    }

    public static Swing optionPane(CharSequence... swing) {
        return new Swing(new JOptionPane(), swing);
    }

    public static Swing panel(CharSequence... swing) {
        return new Swing(new JPanel(), swing);
    }

    public static Swing passwordField(CharSequence... swing) {
        return new Swing(new JPasswordField(), swing);
    }

    public static Swing popupMenu(CharSequence... swing) {
        return new Swing(new JPopupMenu(), swing);
    }

    public static Swing progressBar(CharSequence... swing) {
        return new Swing(new JProgressBar(), swing);
    }

    public static Swing radioButton(CharSequence... swing) {
        return new Swing(new JRadioButton(), swing);
    }

    public static Swing radioButtonMenuItem(CharSequence... swing) {
        return new Swing(new JRadioButtonMenuItem(), swing);
    }

    public static Swing rootPane(CharSequence... swing) {
        return new Swing(new JRootPane(), swing);
    }

    public static Swing scrollBar(CharSequence... swing) {
        return new Swing(new JScrollBar(), swing);
    }

    public static Swing scrollPane(CharSequence... swing) {
        return new Swing(new JScrollPane(), swing);
    }

    public static Swing separator(CharSequence... swing) {
        return new Swing(new JSeparator(), swing);
    }

    public static Swing slider(CharSequence... swing) {
        return new Swing(new JSlider(), swing);
    }

    public static Swing spinner(CharSequence... swing) {
        return new Swing(new JSpinner(), swing);
    }

    public static Swing splitPane(CharSequence... swing) {
        return new Swing(new JSplitPane(), swing);
    }

    public static Swing tabbedPane(CharSequence... swing) {
        return new Swing(new JTabbedPane(), swing);
    }

    public static Swing table(CharSequence... swing) {
        return new Swing(new JTable(), swing);
    }

    public static Swing<JTable> table(String[] header, Object[]... rows) {
        return new Swing(new JTable(rows, header));
    }

    public static String[] header(String... columnTitles) {
        return columnTitles;
    }

    public static Object[] row(Object... cells) {
        return cells;
    }

    public static Swing textArea(CharSequence... swing) {
        return new Swing(new JTextArea(), swing);
    }

    public static Swing textField(CharSequence... swing) {
        return new Swing(new JTextField(), swing);
    }

    public static Swing textPane(CharSequence... swing) {
        return new Swing(new JTextPane(), swing);
    }

    public static Swing toggleButton(CharSequence... swing) {
        return new Swing(new JToggleButton(), swing);
    }

    public static Swing toolBar(CharSequence... swing) {
        return new Swing(new JToolBar(), swing);
    }

    public static Swing toolTip(CharSequence... swing) {
        return new Swing(new JToolTip(), swing);
    }

    public static Swing tree(CharSequence... swing) {
        return new Swing(new JTree(), swing);
    }

    public static Swing viewport(CharSequence... swing) {
        return new Swing(new JViewport(), swing);
    }


    public static Swing<AbstractButton>[] buttonGroup(Swing<AbstractButton>... buttons) {
        ButtonGroup buttonGroup = new ButtonGroup();
        for (Swing<AbstractButton> button : buttons) {
            buttonGroup.add(button.getView());
        }
        return buttons;
    }


    private SwingFactory() {
    }
}
