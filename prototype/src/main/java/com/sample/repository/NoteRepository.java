package com.sample.repository;

import com.sample.model.Note;
import org.fluentness.repository.AbstractCrudRepository;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

public class NoteRepository extends AbstractCrudRepository<Note> {

    public NoteRepository(Persistence persistence, Log log) {
        super(persistence, log, Note.class);
    }
}
