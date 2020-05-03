package com.sample.controller;

import com.sample.service.Calendar;
import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.html.Html;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.fluentness.controller.web.html.HtmlAttribute.CLASS;
import static org.fluentness.controller.web.html.HtmlAttribute.HREF;
import static org.fluentness.controller.web.html.HtmlFactory.*;

public class WebEventsController extends AbstractWebController {

    private final Calendar calendar;

    @BasePath("/events")
    public WebEventsController(Calendar calendar) {
        super(Web.class);
        this.calendar = calendar;
    }

    @Action
    Html events(int year, int month) {
        YearMonth current = (year == 0 && month == 0) ? YearMonth.now() : YearMonth.of(year, month);
        YearMonth previous = current.minusMonths(1);
        YearMonth next = current.plusMonths(1);
        List<LocalDate> days = calendar.getDays(current);
        return div(CLASS + "calendar",
            h2(
                i(CLASS + "icono-calendar"),
                current.format(DateTimeFormatter.ofPattern("MMMM y", request.get().getLocale())),
                div(CLASS + "right",
                    a(HREF + "/events?year=" + previous.getYear() + "&month=" + previous.getMonthValue(),
                        i(CLASS + "icono-caretLeftCircle")
                    ),
                    a(HREF + "/events?year=" + next.getYear() + "&month=" + next.getMonthValue(),
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