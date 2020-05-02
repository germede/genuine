package com.sample.controller;

import com.sample.repository.UserRepository;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.template.html.Html;

import static com.sample.service.Translator.*;
import static org.fluentness.controller.web.template.html.HtmlAttribute.*;
import static org.fluentness.controller.web.template.html.HtmlFactory.*;

public class WebUsersController extends AbstractWebController<WebView> {

    private final UserRepository userRepository;

    @BasePath("/users")
    public WebUsersController(UserRepository userRepository) {
        super(new WebView());
        this.userRepository = userRepository;
    }

    @Action(path = "/")
    Html users() {
        return div(
            table(
                forEach(userRepository.select(), user ->
                    tr(
                        td(i(CLASS + "icono-user"), user.getUsername()),
                        td(CLASS + "right",
                            i(CLASS + "icono-trash"),
                            i(CLASS + "icono-sliders")
                        )
                    )
                )
            ),
            label(FOR + "new-user-modal", CLASS + "button full", i(CLASS + "icono-plusCircle"), _create),
            div(CLASS + "modal",
                input(ID + "new-user-modal", TYPE + "checkbox"),
                label(FOR + "new-user-modal", CLASS + "overlay"),
                article(
                    header(
                        h3(_create),
                        label(FOR + "new-user-modal", CLASS + "close", "&times;")
                    ),
                    section(CLASS + "content",
                        form(
                            input(TYPE + "text", PLACEHOLDER + _user_username),
                            input(TYPE + "password", PLACEHOLDER + _user_password)
                        )
                    ),
                    footer(
                        label(FOR + "new-user-modal", CLASS + "button", _cancel),
                        a(CLASS + "button right success", _submit)
                    )
                )
            )
        );
    }
}