package org.backlog;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainPanelBackground extends JPanel {

    private static final String IMAGE_PATH = "art/logo.png";

    private final int DURATION = 3000;
    private final int DISTANCE = 200;
    private final int NR_STEPS = 100;

    private BufferedImage image = ImageIO.read(new File(IMAGE_PATH));

    private int currentStep = 0;
    private Timer animationTimer = new Timer(DURATION / NR_STEPS, actionEvent -> {
        if (currentStep < NR_STEPS) {
            int y = getLocation().y + DISTANCE / NR_STEPS;
            setLocation(getLocation().x, y);
            currentStep++;
        } else {
            stopAnimation();
        }
    });

    public MainPanelBackground() throws IOException {
        setBorder(new EmptyBorder(250, 250, 250, 250));
        setPreferredSize(new Dimension(1000,500));
        setVisible(true);
        startAnimation();
    }

    private void startAnimation() {
        animationTimer.start();
    }

    private void stopAnimation() {
        animationTimer.stop();
        currentStep = 0;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, this);
    }
}
