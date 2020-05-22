package org.fluentness.prototype.controller;

import com.j256.ormlite.table.TableUtils;
import org.fluentness.controller.AbstractConsoleController;
import org.fluentness.prototype.model.Note;
import org.fluentness.prototype.model.User;
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
