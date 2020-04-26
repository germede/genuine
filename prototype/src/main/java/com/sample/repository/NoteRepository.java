package com.sample.repository;

import org.fluentness.repository.crud.AbstractRepository;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

public class NoteRepository extends AbstractRepository<Note> {

    public NoteRepository(Persistence persistence, Log log) {
        super(persistence, log, Note.class);
    }
}
