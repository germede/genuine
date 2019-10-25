package com.sample;

import com.sample.base.LocalizationService;
import com.sample.data.BookRepository;
import com.sample.flow.LibraryController;
import org.fluentness.Fluentness;

public class BookLibraryApp {

    public static void main(String[] args) {

        Fluentness.define(
                base -> base.add(LocalizationService.class),
                data -> data.add(BookRepository.class),
                flow -> flow.add(LibraryController.class)
        );

        Fluentness.invoke(args);
    }
}
