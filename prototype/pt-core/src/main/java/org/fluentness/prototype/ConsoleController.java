package org.fluentness.prototype;

import com.j256.ormlite.table.TableUtils;
import org.fluentness.controller.action.AbstractConsoleController;
import org.fluentness.prototype.note.Note;
import org.fluentness.prototype.user.User;
import org.fluentness.service.persistence.Persistence;

import java.sql.SQLException;

public class ConsoleController extends AbstractConsoleController {

    private Persistence persistence;

    public ConsoleController(Persistence persistence) {
        this.persistence = persistence;
    }

    @Action()
    public void createTables() throws SQLException {
        TableUtils.createTableIfNotExists(persistence.getConnectionSource(), User.class);
        TableUtils.createTableIfNotExists(persistence.getConnectionSource(), Note.class);
    }
}
