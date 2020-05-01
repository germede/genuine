package com.sample.controller;

import com.sample.repository.Note;
import com.sample.repository.NoteRepository;
import com.sample.service.Calendar;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.template.html.Html;
import org.fluentness.service.mail.Mail;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.sample.service.Translator.*;
import static org.fluentness.controller.web.template.html.HtmlAttribute.*;
import static org.fluentness.controller.web.template.html.HtmlFactory.*;

public class WebController extends AbstractWebController<WebView> {

    private final Calendar calendar;
    private final NoteRepository noteRepository;
    private final Mail mail;

    public WebController(Calendar calendar, NoteRepository noteRepository, Mail mail) {
        super(new WebView());
        this.calendar = calendar;
        this.noteRepository = noteRepository;
        this.mail = mail;
    }

    @Action(path = "/")
    Html index() {
        return notes();
    }

    @Action(path = "/notes")
    Html notes() {
        noteRepository.insert(new Note("Title", "Description", 0));

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