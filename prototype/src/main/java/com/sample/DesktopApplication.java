package com.sample;

import com.sample.controller.GameController;
import com.sample.repository.GameRepository;
import com.sample.service.MapConfiguration;
import org.fluentness.AbstractDesktopApplication;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.Src;
import org.fluentness.service.persistence.JdbcPersistence;

import javax.swing.*;

@Src(
    services = {
        JdbcPersistence.class,
        MapConfiguration.class,
    },
    repositories = GameRepository.class,
    controllers = GameController.class
)
public class DesktopApplication extends AbstractDesktopApplication {

    public static void main(String[] args) throws FluentnessException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        Fluentness.launch(new DesktopApplication(), args);
    }
}
