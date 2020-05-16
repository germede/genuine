package com.sample.controller;

import org.fluentness.controller.AbstractWebController;
import org.fluentness.controller.html.Html;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import static org.fluentness.controller.AbstractWeb.*;
import static org.fluentness.controller.html.HtmlAttribute.CLASS;
import static org.fluentness.controller.html.HtmlAttribute.HREF;

public class WebBookmarksController extends AbstractWebController<Web> {

    @BasePath("/calendar")
    public WebBookmarksController(Web web) {
        super(web);
    }

    @Action
    Html month(int year, int month) {
        YearMonth current = (year == 0 && month == 0) ? YearMonth.now() : YearMonth.of(year, month);
        YearMonth previous = current.minusMonths(1);
        YearMonth next = current.plusMonths(1);
        List<LocalDate> days = getDays(current);
        return div(CLASS + "calendar",
            h2(
                i(CLASS + "icono-calendar"),
                current.format(DateTimeFormatter.ofPattern("MMMM y", request.get().getLocale())),
                div(CLASS + "right",
                    a(HREF + "/calendar/month?year=" + previous.getYear() + "&month=" + previous.getMonthValue(),
                        i(CLASS + "icono-caretLeftCircle")
                    ),
                    a(HREF + "/calendar/month?year=" + next.getYear() + "&month=" + next.getMonthValue(),
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

    private List<LocalDate> getDays(YearMonth month) {
        List<LocalDate> days = new LinkedList<>();
        LocalDate firstDay = month.atDay(1);
        LocalDate lastDay = month.atDay(month.lengthOfMonth());

        for (int i = firstDay.getDayOfWeek().getValue() - 1; i > 0; i--) {
            days.add(firstDay.minusDays(i));
        }
        for (int j = 1; j < month.lengthOfMonth() + 1; j++) {
            days.add(month.atDay(j));
        }
        for (int k = 1; k < 8 - lastDay.getDayOfWeek().getValue(); k++) {
            days.add(lastDay.plusDays(k));
        }
        return days;
    }

}