package org.fluentness.view;

import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.Layout;
import org.fluentness.view.component.container.SwingLinearLayout;
import org.fluentness.view.component.table.SwingTable;
import org.fluentness.view.component.text.SwingButton;

import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public abstract class AbstractDesktopView extends AbstractView<
    Component,
    Layout,
    SwingButton,
    SwingTable,
    SwingLinearLayout
    > {

    private JFrame jFrame;

    public AbstractDesktopView(CharSequence title) {
        this(title, UIManager.getSystemLookAndFeelClassName());
    }

    public AbstractDesktopView(CharSequence title, String lookAndFeelClassName) {
        try {
            UIManager.setLookAndFeel(lookAndFeelClassName);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        jFrame = new JFrame(title.toString());
        jFrame.setContentPane((java.awt.Container) structure());
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
    }

    public JFrame getJFrame() {
        jFrame.pack();
        jFrame.setVisible(true);
        return jFrame;
    }

    @Override
    protected SwingLinearLayout linearLayout(int orientation, Component... components) {
        return new SwingLinearLayout(orientation, components);
    }

    @Override
    protected SwingButton button(CharSequence text) {
        return new SwingButton(text);
    }

    @Override
    protected SwingTable table(CharSequence[] header, Object[]... rows) {
        return new SwingTable(header, rows);
    }

    //
//    protected static org.fluentness.view.SwingTemplate window(java.awt.Container container) {
//        JWindow item = new JWindow();
//        item.setContentPane(container);
//        item.pack();
//        return new org.fluentness.view.SwingTemplate(item);
//    }
//
//    protected static org.fluentness.view.SwingTemplate frame(String title, java.awt.Container container) {
//        JFrame item = new JFrame(title);
//        item.setContentPane(container);
//        item.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        item.pack();
//        return new org.fluentness.view.SwingTemplate(item);
//    }
//
//    protected static org.fluentness.view.SwingTemplate dialog(java.awt.Container container) {
//        JDialog item = new JDialog();
//        item.setContentPane(container);
//        item.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        item.pack();
//        return new org.fluentness.view.SwingTemplate(item);
//    }
//
//    protected static JApplet applet(java.awt.Container... swing) {
//        return addChild(new JApplet(), swing);
//    }
//
//    protected static JButton button(String text) {
//        return new JButton(text);
//    }
//
//    protected static AbstractButton[] buttonGroup(AbstractButton... buttons) {
//        ButtonGroup buttonGroup = new ButtonGroup();
//        for (AbstractButton button : buttons) {
//            buttonGroup.add(button);
//        }
//        return buttons;
//    }
//
//    protected static JCheckBox checkBox(java.awt.Container... swing) {
//        return addChild(new JCheckBox(), swing);
//    }
//
//    protected static JCheckBoxMenuItem checkBoxMenuItem(String text) {
//        return new JCheckBoxMenuItem(text);
//    }
//
//    protected static JColorChooser colorChooser() {
//        return new JColorChooser();
//    }
//
//    protected static JComboBox comboBox(java.awt.Container... swing) {
//        return addChild(new JComboBox(), swing);
//    }
//
//    protected static JDesktopPane desktopPane(java.awt.Container... swing) {
//        return addChild(new JDesktopPane(), swing);
//    }
//
//    protected static JEditorPane editorPane(java.awt.Container... swing) {
//        return addChild(new JEditorPane(), swing);
//    }
//
//    protected static JFileChooser fileChooser(java.awt.Container... swing) {
//        return addChild(new JFileChooser(), swing);
//    }
//
//    protected static JFormattedTextField formattedTextField(java.awt.Container... swing) {
//        return addChild(new JFormattedTextField(), swing);
//    }
//
//    protected static JInternalFrame internalFrame(java.awt.Container... swing) {
//        return addChild(new JInternalFrame(), swing);
//    }
//
//    protected static JLabel label(java.awt.Container... swing) {
//        return addChild(new JLabel(), swing);
//    }
//
//    protected static JLayer layer(java.awt.Container... swing) {
//        return addChild(new JLayer(), swing);
//    }
//
//    protected static JLayeredPane layeredPane(java.awt.Container... swing) {
//        return addChild(new JLayeredPane(), swing);
//    }
//
//    protected static JList list(java.awt.Container... swing) {
//        return addChild(new JList(), swing);
//    }
//
//    protected static JMenu menu(String title, java.awt.Container... swing) {
//        return addChild(new JMenu(title), swing);
//    }
//
//    protected static JMenuBar menuBar(java.awt.Container... swing) {
//        return addChild(new JMenuBar(), swing);
//    }
//
//    protected static JMenuItem menuItem(String text) {
//        return new JMenuItem(text);
//    }
//
//    protected static JOptionPane optionPane(java.awt.Container... swing) {
//        return addChild(new JOptionPane(), swing);
//    }
//
//    protected static JPanel panel(java.awt.Container... swing) {
//        return addChild(new JPanel(), swing);
//    }
//
//    protected static JPasswordField passwordField(java.awt.Container... swing) {
//        return addChild(new JPasswordField(), swing);
//    }
//
//    protected static JPopupMenu popupMenu(java.awt.Container... swing) {
//        return addChild(new JPopupMenu(), swing);
//    }
//
//    protected static JProgressBar progressBar(java.awt.Container... swing) {
//        return addChild(new JProgressBar(), swing);
//    }
//
//    protected static JRadioButton radioButton(java.awt.Container... swing) {
//        return addChild(new JRadioButton(), swing);
//    }
//
//    protected static JRadioButtonMenuItem radioButtonMenuItem(java.awt.Container... swing) {
//        return addChild(new JRadioButtonMenuItem(), swing);
//    }
//
//    protected static JRootPane rootPane(java.awt.Container... swing) {
//        return addChild(new JRootPane(), swing);
//    }
//
//    protected static JScrollBar scrollBar(java.awt.Container... swing) {
//        return addChild(new JScrollBar(), swing);
//    }
//
//    protected static JScrollPane scrollPane(java.awt.Container... swing) {
//        return addChild(new JScrollPane(), swing);
//    }
//
//    protected static JSeparator separator(java.awt.Container... swing) {
//        return addChild(new JSeparator(), swing);
//    }
//
//    protected static JSlider slider(java.awt.Container... swing) {
//        return addChild(new JSlider(), swing);
//    }
//
//    protected static JSpinner spinner(java.awt.Container... swing) {
//        return addChild(new JSpinner(), swing);
//    }
//
//    protected static JSplitPane splitPane(java.awt.Container... swing) {
//        return addChild(new JSplitPane(), swing);
//    }
//
//    protected static JTabbedPane tabbedPane(java.awt.Container... swing) {
//        return addChild(new JTabbedPane(), swing);
//    }
//
//    protected static JTable table(java.awt.Container... swing) {
//        return addChild(new JTable(), swing);
//    }
//
//    protected static JTable table(String[] header, Object[]... rows) {
//        return new JTable(rows, header);
//    }
//
//    protected static String[] header(String... columnTitles) {
//        return columnTitles;
//    }
//
//    protected static Object[] row(Object... cells) {
//        return cells;
//    }
//
//    protected static JTextArea textArea(java.awt.Container... swing) {
//        return addChild(new JTextArea(), swing);
//    }
//
//    protected static JTextField textField(java.awt.Container... swing) {
//        return addChild(new JTextField(), swing);
//    }
//
//    protected static JTextPane textPane(java.awt.Container... swing) {
//        return addChild(new JTextPane(), swing);
//    }
//
//    protected static JToggleButton toggleButton(java.awt.Container... swing) {
//        return addChild(new JToggleButton(), swing);
//    }
//
//    protected static JToolBar toolBar(java.awt.Container... swing) {
//        return addChild(new JToolBar(), swing);
//    }
//
//    protected static JToolTip toolTip(java.awt.Container... swing) {
//        return addChild(new JToolTip(), swing);
//    }
//
//    protected static JTree tree(java.awt.Container... swing) {
//        return addChild(new JTree(), swing);
//    }
//
//    protected static JViewport viewport(java.awt.Container... swing) {
//        return addChild(new JViewport(), swing);
//    }
//
//    private static <C extends java.awt.Container> C addChild(C container, java.awt.Container[] containers) {
//        for (java.awt.Container swing : containers) {
//            container.add(swing);
//        }
//        return container;
//    }

}
