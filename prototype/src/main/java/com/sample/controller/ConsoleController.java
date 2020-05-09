package com.sample.controller;

import com.sample.repository.NoteRepository;
import org.fluentness.controller.AbstractConsoleController;

import java.util.stream.Collectors;

public class ConsoleController extends AbstractConsoleController {

    private final NoteRepository noteRepository;

    public ConsoleController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Action(description = "Print all notes containing name", category = "library")
    String search_notes(String name, int limit) {
        return noteRepository.selectByField("name", name).stream()
            .map(Object::toString)
            .collect(Collectors.joining("\n"));
    }
}