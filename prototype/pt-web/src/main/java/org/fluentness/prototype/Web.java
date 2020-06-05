package org.fluentness.prototype;

import org.fluentness.AbstractWeb;
import org.fluentness.Fluentness;
import org.fluentness.FluentnessException;
import org.fluentness.prototype.calendar.CalendarController;
import org.fluentness.prototype.index.IndexController;
import org.fluentness.prototype.note.NoteController;
import org.fluentness.prototype.service.Configuration;
import org.fluentness.service.Services;
import org.fluentness.service.server.Server;

@Services({
    Configuration.class,
})
public class Web extends AbstractWeb {

    public Web(Server server,
               IndexController indexController,
               CalendarController calendarController,
               NoteController noteController
    ) {
        super(server, indexController, calendarController, noteController);
    }

    public static void main(String[] args) throws FluentnessException {
        Fluentness.launch(Web.class, args);
    }
}
