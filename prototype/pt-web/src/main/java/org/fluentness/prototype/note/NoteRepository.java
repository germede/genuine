package org.fluentness.prototype.note;

import org.fluentness.repository.AbstractCrudRepository;
import org.fluentness.service.persistence.Persistence;

import java.sql.SQLException;

public class NoteRepository extends AbstractCrudRepository<Note> {

    public NoteRepository(Persistence persistence) throws SQLException {
        super(persistence, Note.class);
    }

}
