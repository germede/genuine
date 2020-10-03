package org.fluentness.prototype.view;

import org.fluentness.view.WebView;
import org.fluentness.view.component.HtmlComponent;
import org.fluentness.view.component.modal.HtmlModal;
import org.fluentness.view.component.button.HtmlButton;

import java.util.Date;

import static org.fluentness.view.component.text.Heading.Level.*;
import static org.fluentness.view.component.text.Button.Type.*;

public class IndexView extends WebView {

    public HtmlButton openModalButton;
    public HtmlModal modal;

    @Override
    protected HtmlComponent structure() {
        return linearLayout(
            button("one"),
            button("two"),
            button("three"),
            openModalButton = button("open modal"),
            modal = modal(text("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")),
            table(
                header("this", "is", "a", "asdf"),
                row("this", "is", "a", "row"),
                row(123, false, new Date(0))
            ),
            tabLayout(
                tab("First tab", button("button in tab 1")),
                tab("Second tab", button("button in tab 2")),
                tab("Third tab", button("button in tab 3"))
            ),
            separator(),
            linearLayout(heading("Headings"),
                heading(H1, "H1 heading"),
                heading(H2, "H2 heading"),
                heading(H3, "H3 heading"),
                heading(H4, "H4 heading"),
                heading(H5, "H5 heading"),
                heading(H6, "H6 heading")
            ),
            separator(),
            linearLayout(
                heading("Texts"),
                text("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.")
            ),
            separator(),
            linearLayout(heading("Buttons"),
                button(PRIMARY, "Primary"),
                button(SECONDARY, "Secondary"),
                button(SUCCESS, "Success"),
                button(WARNING, "Warning"),
                button(DANGER, "Danger"),
                button(LIGHT, "Light"),
                button(DARK, "Dark"),
                button(TRANSPARENT, "Transparent"),
                button(DISABLED, "Disabled")
            )
        );
    }
}