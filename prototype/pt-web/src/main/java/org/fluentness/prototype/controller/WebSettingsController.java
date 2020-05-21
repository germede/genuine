package org.fluentness.prototype.controller;

import org.fluentness.prototype.model.User;
import org.fluentness.prototype.repository.UserRepository;
import org.fluentness.prototype.view.WebView;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.view.html.Html;

import static org.fluentness.prototype.service.Localization.*;
import static org.fluentness.view.AbstractWebView.*;
import static org.fluentness.view.html.HtmlAttribute.*;

public class WebSettingsController extends AbstractWebController {

    private final UserRepository userRepository;

    @BasePath("/users")
    public WebSettingsController(WebView web, UserRepository userRepository) {
        super(web);
        this.userRepository = userRepository;
    }

    @Action
    Html users() {
        return div(
            header(
                h2(i(CLASS + "icono-user"), _users),
                label(FOR + "new-user-modal", CLASS + "right button success", _create)
            ),
            table(
                forEach(userRepository.select(), user ->
                    tr(
                        td(user.getUsername()),
                        td(CLASS + "right",
                            i(CLASS + "icono-sliders"),
                            a(HREF + "/users/delete?id=" + user.getId(), i(CLASS + "icono-trash"))
                        )
                    )
                )
            ),
            div(CLASS + "modal",
                input(ID + "new-user-modal", TYPE + "checkbox"),
                label(FOR + "new-user-modal", CLASS + "overlay"),
                form(ACTION + "/users/create", METHOD + "GET",
                    article(
                        header(
                            h3(_create),
                            label(FOR + "new-user-modal", CLASS + "close", "&times;")
                        ),
                        section(CLASS + "content",
                            input(NAME + "username", TYPE + "text", PLACEHOLDER + _user_username),
                            input(NAME + "password", TYPE + "password", PLACEHOLDER + _user_password)
                        ),
                        footer(
                            label(FOR + "new-user-modal", CLASS + "button", _cancel),
                            input(TYPE + "submit", CLASS + "button right success", _submit)
                        )
                    )
                )
            )
        );
    }

    @Action
    Html create(String username, String password) {
        userRepository.insert(new User(0, username, password));
        return users();
    }

    @Action
    Html delete(int id) {
        userRepository.delete(id);
        return users();
    }
}