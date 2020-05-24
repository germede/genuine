package org.fluentness.prototype.view;

import org.fluentness.view.AbstractWebView;
import org.fluentness.view.component.HtmlButton;
import org.fluentness.view.container.HtmlContainer;
import org.fluentness.view.container.HtmlLinearLayout;

import static org.fluentness.view.component.HtmlAttribute.*;
import static org.fluentness.view.container.LinearLayout.VERTICAL;

public class WebView extends AbstractWebView {

    public HtmlButton button1;
    public HtmlLinearLayout root;

    public WebView() {
        super("Fluentness rocks",
            meta(NAME + "lang", CONTENT + "en"),
            meta(CHARSET + "UTF-8"),
            meta(NAME + "viewport", CONTENT + "width=device-width, initial-scale=1")
        );

        root.setPadding(50, 50, 50, 50);
    }

    @Override
    protected HtmlContainer structure() {
        return root = linearLayout(VERTICAL,
            button1 = button("one"),
            button("two"),
            button("three")
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