package com.sample.controller;

import com.sample.repository.Author;
import com.sample.repository.AuthorRepository;
import org.fluentness.controller.desktop.AbstractDesktopController;
import org.fluentness.controller.desktop.view.SwingViewRegistry;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

public class DesktopController extends AbstractDesktopController<Desktop> {

    private final Desktop desktop;
    private final AuthorRepository authorRepository;

    public DesktopController(AuthorRepository authorRepository) throws SQLException {
        super(Desktop.class);
        this.desktop = new Desktop(this);
        this.authorRepository = authorRepository;
        List<Author> authors = authorRepository.queryForAll();
        authorRepository.queryForAll();
    }

    public void test(CaretEvent caretEvent) {

        JCheckBox checkbox_2 = (JCheckBox) SwingViewRegistry.getByName(JCheckBox.class, "checkbox_2");
        checkbox_2.setText(checkbox_2.getText() + "HAHA");
    }

    public void cutPressed(ActionEvent event) {
        int i = 2;
    }

}
