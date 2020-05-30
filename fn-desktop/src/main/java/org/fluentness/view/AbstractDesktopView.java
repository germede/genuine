package org.fluentness.view;

import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.layout.SwingLinearLayout;
import org.fluentness.view.component.layout.SwingTabLayout;
import org.fluentness.view.component.layout.TabLayout;
import org.fluentness.view.component.table.SwingTable;
import org.fluentness.view.component.table.Table;
import org.fluentness.view.component.text.Button;
import org.fluentness.view.component.text.SwingButton;

import javax.swing.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public abstract class AbstractDesktopView extends AbstractView {

    private JFrame jFrame;

    public AbstractDesktopView(CharSequence title) {
        this(title, UIManager.getSystemLookAndFeelClassName());
    }

    public AbstractDesktopView(CharSequence title, String lookAndFeelClassName) {
        super(title);
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
    protected LinearLayout linearLayout(Component... components) {
        return new SwingLinearLayout(components);
    }

    @Override
    protected Button button(CharSequence text) {
        return new SwingButton(text);
    }

    @Override
    protected Table table(CharSequence[] header, Object[]... rows) {
        return new SwingTable(header, rows);
    }

    @Override
    protected TabLayout tabLayout(TabLayout.Tab... tabs) {
        return new SwingTabLayout(tabs);
    }

}
