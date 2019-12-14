package com.sample.controller;

import com.sample.repository.AuthorRepository;
import com.sample.repository.BookRepository;
import com.sample.repository.UserRepository;
import com.sample.view.DesktopView;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.view.desktop.SwingViewRegistry;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import java.awt.event.ActionEvent;

public class DesktopController extends AbstractDesktopController<DesktopView> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private UserRepository userRepository;

    public DesktopController(
        BookRepository bookRepository,
        AuthorRepository authorRepository,
        UserRepository userRepository
    ) {
        super(DesktopView.class);
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.userRepository = userRepository;
    }

    public void test(CaretEvent caretEvent) {
        JCheckBox checkbox_2 = (JCheckBox) SwingViewRegistry.getByName(JCheckBox.class, "checkbox_2");
        checkbox_2.setText(checkbox_2.getText() + "HAHA");
    }

    public void cutPressed(ActionEvent event) {
        int i = 2;
    }

}
