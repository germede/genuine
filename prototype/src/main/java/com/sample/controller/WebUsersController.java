package com.sample.controller;

import com.sample.repository.User;
import com.sample.repository.UserRepository;
import org.fluentness.controller.AbstractWebController;
import org.fluentness.controller.html.Html;

import static com.sample.Translations.*;
import static org.fluentness.controller.html.HtmlAttribute.*;
import static org.fluentness.controller.html.HtmlFactory.*;

public class WebUsersController extends AbstractWebController {

    private final UserRepository userRepository;

    @BasePath("/users")
    public WebUsersController(UserRepository userRepository) {
        super(Web.class);
        this.userRepository = userRepository;
    }

    @Action
    Html users() {
        return div(
            table(
                forEach(userRepository.select(), user ->
                    tr(
                        td(i(CLASS + "icono-user"), user.getUsername()),
                        td(CLASS + "right",
                            a(HREF + "/users/delete?id=" + user.getId(),
                                i(CLASS + "icono-trash")
                            ),
                            i(CLASS + "icono-sliders")
                        )
                    )
                )
            ),
            label(FOR + "new-user-modal", CLASS + "button full", i(CLASS + "icono-plusCircle"), _create),
            div(CLASS + "modal",
                input(ID + "new-user-modal", TYPE + "checkbox"),
                label(FOR + "new-user-modal", CLASS + "overlay"),
                form(ID + "newUser", METHOD + "GET",
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

    @Action(path = "/new")
    Html newUser(String username, String password) {
        userRepository.insert(new User(username, password));
        return users();
    }

    @Action(path = "/delete")
    Html deleteUser(int id) {
        userRepository.delete(id);
        return users();
    }
}