package org.fluentness.controller.web.template.html;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class HtmlConverter {

    public static final Pattern COMPILE = Pattern.compile("<(?!!)(?!/)\\s*([a-zA-Z0-9]+)(.*?)>(.+)<");
    public static final Pattern COMPILE1 = Pattern.compile("(\\S+)=['\"]{1}([^>]*?)['\"]{1}");

    public HtmlConverter() {

        JFrame frame = new JFrame();
        JTextPane input = new JTextPane();
        JButton button = new JButton("Convert");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000, 300));

        ScrollPane inputScroll = new ScrollPane();
        inputScroll.add(input);

        frame.setLayout(new BorderLayout());
        frame.add(inputScroll, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

        button.addActionListener(e -> {
            input.setText(convert(input.getText()));
        });
    }

    public String convert(String text) {

        text = text.replaceAll("<(\\w+)\\s", "$1(");
        text = text.replaceAll("\\s(\\w+)=\"([\\w\\s]+)\"", "$1 + \"$2\", ");
        text = text.replaceAll("</\\w*>", "),");
        text = text.replaceAll(">", "");
        // todo improve
        return text;
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new HtmlConverter();
    }
}