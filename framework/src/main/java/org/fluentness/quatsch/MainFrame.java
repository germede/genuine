package org.fluentness.quatsch;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {

    public static void main(String[] args) {
        try {
            setSystemLookAndFeel();
            new MainFrame();
        } catch (ClassNotFoundException | IOException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private static void setSystemLookAndFeel() throws
            ClassNotFoundException,
            UnsupportedLookAndFeelException,
            InstantiationException,
            IllegalAccessException {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }

    private MainFrame() throws HeadlessException, IOException {
        setContentPane(new MainPanel());
        setTitle("Fluentness bootsrap");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 180, 140);
        pack();
        center();
        setVisible(true);
    }

    private void center() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - getHeight()) / 2);
        setLocation(x, y);
    }
}
