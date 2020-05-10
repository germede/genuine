package org.fluentness.view;

import org.fluentness.view.Swing.Swing;
import org.fluentness.view.Swing.SwingWindow;

import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public abstract class AbstractDesktopView implements View {

    private final RootDesktopView rootDesktopView;

    public AbstractDesktopView(RootDesktopView rootDesktopView) {
        this.rootDesktopView = rootDesktopView;
    }

    public RootDesktopView getRootDesktopView() {
        return rootDesktopView;
    }

    protected static SwingWindow window(Swing content) {
        JWindow item = new JWindow();
        item.setContentPane(content.getView());
        item.pack();
        return new SwingWindow(item, content);
    }

    protected static SwingWindow frame(String title, Swing content) {
        JFrame item = new JFrame(title);
        item.setContentPane(content.getView());
        item.setDefaultCloseOperation(EXIT_ON_CLOSE);
        item.pack();
        return new SwingWindow(item, content);
    }

    protected static SwingWindow dialog(Swing content) {
        JDialog item = new JDialog();
        item.setContentPane(content.getView());
        item.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        item.pack();
        return new SwingWindow(item, content);
    }

    protected static Swing applet(CharSequence... swing) {
        return new Swing(new JApplet(), swing);
    }

    protected static Swing button(CharSequence... swing) {
        return new Swing(new JButton(), swing);
    }

    protected static Swing checkBox(CharSequence... swing) {
        return new Swing(new JCheckBox(), swing);
    }

    protected static Swing checkBoxMenuItem(CharSequence... swing) {
        return new Swing(new JCheckBoxMenuItem(), swing);
    }

    protected static Swing colorChooser(CharSequence... swing) {
        return new Swing(new JColorChooser(), swing);
    }

    protected static Swing comboBox(CharSequence... swing) {
        return new Swing(new JComboBox(), swing);
    }

    protected static Swing desktopPane(CharSequence... swing) {
        return new Swing(new JDesktopPane(), swing);
    }

    protected static Swing editorPane(CharSequence... swing) {
        return new Swing(new JEditorPane(), swing);
    }

    protected static Swing fileChooser(CharSequence... swing) {
        return new Swing(new JFileChooser(), swing);
    }

    protected static Swing formattedTextField(CharSequence... swing) {
        return new Swing(new JFormattedTextField(), swing);
    }

    protected static Swing internalFrame(CharSequence... swing) {
        return new Swing(new JInternalFrame(), swing);
    }

    protected static Swing label(CharSequence... swing) {
        return new Swing(new JLabel(), swing);
    }

    protected static Swing layer(CharSequence... swing) {
        return new Swing(new JLayer(), swing);
    }

    protected static Swing layeredPane(CharSequence... swing) {
        return new Swing(new JLayeredPane(), swing);
    }

    protected static Swing list(CharSequence... swing) {
        return new Swing(new JList(), swing);
    }

    protected static Swing menu(CharSequence... swing) {
        return new Swing(new JMenu(), swing);
    }

    protected static Swing menuBar(CharSequence... swing) {
        return new Swing(new JMenuBar(), swing);
    }

    protected static Swing menuItem(CharSequence... swing) {
        return new Swing(new JMenuItem(), swing);
    }

    protected static Swing optionPane(CharSequence... swing) {
        return new Swing(new JOptionPane(), swing);
    }

    protected static Swing panel(CharSequence... swing) {
        return new Swing(new JPanel(), swing);
    }

    protected static Swing passwordField(CharSequence... swing) {
        return new Swing(new JPasswordField(), swing);
    }

    protected static Swing popupMenu(CharSequence... swing) {
        return new Swing(new JPopupMenu(), swing);
    }

    protected static Swing progressBar(CharSequence... swing) {
        return new Swing(new JProgressBar(), swing);
    }

    protected static Swing radioButton(CharSequence... swing) {
        return new Swing(new JRadioButton(), swing);
    }

    protected static Swing radioButtonMenuItem(CharSequence... swing) {
        return new Swing(new JRadioButtonMenuItem(), swing);
    }

    protected static Swing rootPane(CharSequence... swing) {
        return new Swing(new JRootPane(), swing);
    }

    protected static Swing scrollBar(CharSequence... swing) {
        return new Swing(new JScrollBar(), swing);
    }

    protected static Swing scrollPane(CharSequence... swing) {
        return new Swing(new JScrollPane(), swing);
    }

    protected static Swing separator(CharSequence... swing) {
        return new Swing(new JSeparator(), swing);
    }

    protected static Swing slider(CharSequence... swing) {
        return new Swing(new JSlider(), swing);
    }

    protected static Swing spinner(CharSequence... swing) {
        return new Swing(new JSpinner(), swing);
    }

    protected static Swing splitPane(CharSequence... swing) {
        return new Swing(new JSplitPane(), swing);
    }

    protected static Swing tabbedPane(CharSequence... swing) {
        return new Swing(new JTabbedPane(), swing);
    }

    protected static Swing table(CharSequence... swing) {
        return new Swing(new JTable(), swing);
    }

    protected static Swing<JTable> table(String[] header, Object[]... rows) {
        return new Swing(new JTable(rows, header));
    }

    protected static String[] header(String... columnTitles) {
        return columnTitles;
    }

    protected static Object[] row(Object... cells) {
        return cells;
    }

    protected static Swing textArea(CharSequence... swing) {
        return new Swing(new JTextArea(), swing);
    }

    protected static Swing textField(CharSequence... swing) {
        return new Swing(new JTextField(), swing);
    }

    protected static Swing textPane(CharSequence... swing) {
        return new Swing(new JTextPane(), swing);
    }

    protected static Swing toggleButton(CharSequence... swing) {
        return new Swing(new JToggleButton(), swing);
    }

    protected static Swing toolBar(CharSequence... swing) {
        return new Swing(new JToolBar(), swing);
    }

    protected static Swing toolTip(CharSequence... swing) {
        return new Swing(new JToolTip(), swing);
    }

    protected static Swing tree(CharSequence... swing) {
        return new Swing(new JTree(), swing);
    }

    protected static Swing viewport(CharSequence... swing) {
        return new Swing(new JViewport(), swing);
    }

    protected static Swing<AbstractButton>[] buttonGroup(Swing<AbstractButton>... buttons) {
        ButtonGroup buttonGroup = new ButtonGroup();
        for (Swing<AbstractButton> button : buttons) {
            buttonGroup.add(button.getView());
        }
        return buttons;
    }

}
