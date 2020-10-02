package org.fluentness.prototype.view;

import org.fluentness.view.WebView;
import org.fluentness.view.component.Component;

public class CalendarView extends WebView {
    public CalendarView() {
        super(null);
    }

    @Override
    protected Component structure() {
        return null;
    }


//
//    @Override
//    protected Container structure() {
//        return html(
//            head(
//
//            ),
//            body(
//                nav(
//                    input(ID + "burger", TYPE + "checkbox", CLASS + "show"),
//                    label(FOR + "burger", CLASS + "burger pseudo button", Localization._menu),
//                    div(CLASS + "menu",
//                        action(WebController.class, "index", CLASS + "pseudo button", "WorkStation"),
//                        action(WebFilesController.class, "files", CLASS + "pseudo button", Localization._files),
//                        action(WebEmailController.class, "email", CLASS + "pseudo button", Localization._email),
//                        action(WebCalendarController.class, "calendar", CLASS + "pseudo button", Localization._calendar),
//                        action(WebContactsController.class, "contacts", CLASS + "pseudo button", Localization._contacts),
//                        action(WebTasksController.class, "tasks", CLASS + "pseudo button", Localization._tasks),
//                        action(WebNotesController.class, "notes", CLASS + "pseudo button", Localization._notes),
//                        action(WebBookmarksController.class, "bookmarks", CLASS + "pseudo button", Localization._bookmarks),
//                        action(WebPasswordsController.class, "passwords", CLASS + "pseudo button", Localization._passwords),
//                        div(CLASS + "right",
//                            action(WebSettingsController.class, "users", CLASS + "pseudo button right", Localization._users),
//                            action(WebSettingsController.class, "settings", CLASS + "pseudo button right", Localization._settings)
//                        )
//                    )
//                ),
//                div(CLASS + "wrapper card",
//                    ACTION_RESULT
//                )
//            )
//        );
//    }
//
//    @Override
//    protected void style() {
//
//    }

}