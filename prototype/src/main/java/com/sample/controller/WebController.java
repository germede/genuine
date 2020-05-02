package com.sample.controller;

import com.sample.repository.NoteRepository;
import com.sample.repository.UserRepository;
import com.sample.service.Calendar;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.template.html.Html;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.sample.service.Translator.*;
import static org.fluentness.controller.web.template.html.HtmlAttribute.CLASS;
import static org.fluentness.controller.web.template.html.HtmlAttribute.HREF;
import static org.fluentness.controller.web.template.html.HtmlFactory.*;

public class WebController extends AbstractWebController<WebView> {

    private final Calendar calendar;
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public WebController(Calendar calendar, NoteRepository noteRepository, UserRepository userRepository) {
        super(new WebView());
        this.calendar = calendar;
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @Action(path = "/")
    Html index() {
        return notes();
    }

    @Action(path = "/users", selector = "#users")
    Html users() {
        return div(
            table(CLASS + "pure-table",
                thead(
                    th(_user_username),
                    th()
                ),
                tbody(
                    forEach(userRepository.select(), user ->
                        tr(
                            td(i(CLASS + "icono-user"), user.getUsername()),
                            td(
                                i(CLASS + "icono-trash right"),
                                i(CLASS + "icono-sliders right")
                            )
                        )
                    )
                )
            )
        );
    }

    @Action(path = "/notes")
    Html notes() {
        return div(
            table(
                thead(
                    th(_note_title),
                    th(_note_description),
                    th("")
                ),
                tbody(
                    forEach(noteRepository.select(), note ->
                        tr(
                            td(note.getTitle()),
                            td(note.getDescription()),
                            td(
                                button(CLASS + "button button-outline", "\uD83D\uDD89"),
                                button(CLASS + "button", "⨯")
                            )
                        )
                    )
                )
            ),
            div(CLASS + "row",
                button(CLASS + "button column", _create)
            )
        );
    }

    @Action(path = "/calendar", selector = "#calendar")
    Html calendar(int year, int month) {
        YearMonth current = (year == 0 && month == 0) ? YearMonth.now() : YearMonth.of(year, month);
        YearMonth previous = current.minusMonths(1);
        YearMonth next = current.plusMonths(1);
        List<LocalDate> days = calendar.getDays(current);
        return div(CLASS + "calendar",
            h2(
                current.format(DateTimeFormatter.ofPattern("MMMM y", request.get().getLocale())),
                div(CLASS + "right",
                    a(HREF + "/calendar?year=" + previous.getYear() + "&month=" + previous.getMonthValue(),
                        i(CLASS + "icono-caretLeftCircle")
                    ),
                    a(HREF + "/calendar?year=" + next.getYear() + "&month=" + next.getMonthValue(),
                        i(CLASS + "icono-caretRightCircle")
                    )
                )
            ),
            div(CLASS + "flex seven",
                forEach(days, day ->
                    span(CLASS + (day.getMonthValue() == current.getMonthValue() ? "current" : ""),
                        day.getDayOfMonth() + ""
                    )
                )
            )
        );
    }

}