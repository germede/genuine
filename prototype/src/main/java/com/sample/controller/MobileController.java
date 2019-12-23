package com.sample.controller;

import com.sample.view.Desktop;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.view.desktop.SwingViewRegistry;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import java.awt.event.ActionEvent;

public class MobileController extends AbstractDesktopController<Desktop> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private UserRepository userRepository;

    public MobileController(
        BookRepository bookRepository,
        AuthorRepository authorRepository,
        UserRepository userRepository
    ) {
        super(Desktop.class);
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
    }

    void test(CaretEvent caretEvent) {
        JCheckBox checkbox_2 = (JCheckBox) SwingViewRegistry.getByName(JCheckBox.class, "checkbox_2");
        checkbox_2.setText(checkbox_2.getText() + "HAHA");
    }

    void cutPressed(ActionEvent event) {
        int i = 2;
    }

}
