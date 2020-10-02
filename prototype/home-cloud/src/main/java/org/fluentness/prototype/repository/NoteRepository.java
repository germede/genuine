package org.fluentness.prototype.repository;

import org.fluentness.prototype.model.Note;
import org.fluentness.repository.CrudRepository;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

import java.sql.SQLException;

public class NoteRepository extends CrudRepository<Note> {

    public NoteRepository(Persistence persistence, Log log) throws SQLException {
        super(persistence, log, Note.class);
    }

}
