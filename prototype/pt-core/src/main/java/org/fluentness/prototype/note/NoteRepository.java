package org.fluentness.prototype.note;

import org.fluentness.repository.crud.AbstractCrudRepository;
import org.fluentness.service.log.Log;
import org.fluentness.service.persistence.Persistence;

import java.sql.SQLException;

public class NoteRepository extends AbstractCrudRepository<Note> {

    public NoteRepository(Persistence persistence, Log log) throws SQLException {
        super(persistence, log, Note.class);
    }

}
