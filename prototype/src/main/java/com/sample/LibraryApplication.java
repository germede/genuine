package com.sample;

import com.sample.controller.ConsoleController;
import com.sample.controller.DesktopController;
import com.sample.controller.WebController;
import com.sample.repository.AuthorRepository;
import com.sample.repository.BookRepository;
import com.sample.repository.UserRepository;
import com.sample.service.ClockImpl;
import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.Controller;
import org.fluentness.repository.Repository;
import org.fluentness.service.Service;
import org.fluentness.service.authenticator.Authenticator;
import org.fluentness.service.authenticator.BasicAuthenticator;
import org.fluentness.service.configuration.Configuration;
import org.fluentness.service.configuration.MapConfiguration;
import org.fluentness.service.logger.JulLogger;
import org.fluentness.service.logger.LogLevel;
import org.fluentness.service.logger.Logger;
import org.fluentness.service.mailer.Mailer;
import org.fluentness.service.mailer.SocketMailer;
import org.fluentness.service.persistence.JdbcPersistence;
import org.fluentness.service.persistence.Persistence;
import org.fluentness.service.server.Server;
import org.fluentness.service.server.SunServer;
import org.fluentness.service.translator.SimpleTranslator;
import org.fluentness.service.translator.Translator;

import java.net.UnknownHostException;
import java.sql.SQLException;


public class LibraryApplication implements Application {

    @Override
    public Controller[] getControllersInstance() {
        return new Controller[] {
            new ConsoleController(Fluentness.getInstance(BookRepository.class)),
            new DesktopController(Fluentness.getInstance(AuthorRepository.class)),
            new WebController(Fluentness.getInstance(BookRepository.class),Fluentness.getInstance(AuthorRepository.class), Fluentness.getInstance(Mailer.class))
        };
    }

    @Override
    public Repository[] getRepositoriesInstance() {
        return new Repository[] {new AuthorRepository(), new BookRepository(), new UserRepository()};
    }

    @Override
    public Service[] getServicesInstance() {
        return new Service[]{new ClockImpl()};
    }

    @Override
    public Configuration getConfigurationInstance() {
        return new MapConfiguration();
    }

    @Override
    public Logger getLoggerInstance() throws Exception {
        return new JulLogger(Fluentness.getInstance(Configuration.class));
    }

    @Override
    public Mailer getMailerInstance() throws UnknownHostException {
        return new SocketMailer(Fluentness.getInstance(Configuration.class),Fluentness.getInstance(Logger.class));
    }

    @Override
    public Persistence getPersistenceInstance() throws SQLException {
        return new JdbcPersistence(Fluentness.getInstance(Configuration.class), Fluentness.getInstance(Logger.class));
    }

    @Override
    public Translator getTranslatorInstance() {
        return new SimpleTranslator();
    }

    @Override
    public Server getServerInstance() {
        return new SunServer(Fluentness.getInstances(Authenticator.class), Fluentness.getInstance(Configuration.class), Fluentness.getInstance(Logger.class));
    }

    @Override
    public void configure(Configuration configuration) {
        configuration
            .set(Application.NAME, "Library")
            .set(Server.PORT, 8000)
            .set(Logger.LEVEL, LogLevel.DEBUG)
            .set(Logger.CONSOLE, true)
            .set(Persistence.JDBC_URL, "jdbc:mysql://localhost:3306/party")
            .set(Persistence.USERNAME, "party")
            .set(Persistence.PASSWORD, "party")
            .set(BasicAuthenticator.USERNAME, "admin")
            .set(BasicAuthenticator.PASSWORD, "admin");
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new LibraryApplication()).desktop();
    }
}
