package org.fluentness.prototype.view;

import org.fluentness.view.AbstractWebView;
import org.fluentness.view.component.Component;
import org.fluentness.view.component.layout.LinearLayout;
import org.fluentness.view.component.table.Table;
import org.fluentness.view.component.text.Button;

import java.util.Date;

public class NotesView extends AbstractWebView {

    public LinearLayout root;
    public Button button1;
    public Button button2;
    public Table table;

    public NotesView() {
        super("Notes");
    }

    @Override
    protected Component structure() {
        return root = linearLayout(
            button1 = button("one"),
            button2 = button("two"),
            button("three"),
            table = table(
                header("this", "is", "a", "header"),
                row("this", "is", "a", "row"),
                row(123, false, new Date(0))
            ),
            tabLayout(
                tab("First tab", button("button in tab 1")),
                tab("Second tab", button("button in tab 2")),
                tab("Third tab", button("button in tab 3"))
            )
        );
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