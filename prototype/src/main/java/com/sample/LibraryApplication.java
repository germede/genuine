package com.sample;

import com.sample.controller.ConsoleController;
import com.sample.controller.DesktopController;
import com.sample.controller.WebController;
import com.sample.repository.AuthorRepository;
import com.sample.repository.BookRepository;
import com.sample.repository.UserRepository;
import com.sample.service.LibraryConfigurator;
import com.sample.service.LibraryTranslator;
import org.fluentness.Application;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.controller.web.Controller;
import org.fluentness.repository.crud.CrudRepository;
import org.fluentness.service.Service;

public class LibraryApplication implements Application {

    @Override
    public Class<? extends Service>[] getServices() {
        return new Class[]{
            LibraryConfigurator.class,
            LibraryTranslator.class
        };
    }

    @Override
    public Class<? extends CrudRepository>[] getRepositories() {
        return new Class[]{
            AuthorRepository.class,
            BookRepository.class,
            UserRepository.class
        };
    }

    @Override
    public Class<? extends Controller>[] getControllers() {
        return new Class[]{
            ConsoleController.class,
            DesktopController.class,
            WebController.class
        };
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(new LibraryApplication()).web();
    }
}
