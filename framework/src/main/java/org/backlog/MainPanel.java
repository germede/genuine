package org.backlog;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static java.awt.BorderLayout.PAGE_END;
import static java.awt.BorderLayout.PAGE_START;

class MainPanel extends JPanel {

    private MainPanelBackground background = new MainPanelBackground();
    private JButton acceptButton = new JButton("Accept");

    MainPanel() throws IOException {
        setLayout(new BorderLayout());
        acceptButton.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        add(background, PAGE_START);
        add(acceptButton, PAGE_END);

        acceptButton.addActionListener(actionEvent -> {
            JOptionPane.showMessageDialog(null, "WTF");
        });
    }
}
