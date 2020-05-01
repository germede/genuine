package com.sample.service;

import org.fluentness.controller.web.AbstractWebController;
import org.fluentness.controller.web.template.html.Html;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import static org.fluentness.controller.web.template.html.HtmlAttribute.CLASS;
import static org.fluentness.controller.web.template.html.HtmlFactory.*;

public class CalendarImpl implements Calendar {

    @Override
    public Html renderMonthCalendar(int year, int month) {
        YearMonth current = (year == 0 && month == 0) ? YearMonth.now() : YearMonth.of(year, month);

        List<LocalDate> days = new LinkedList<>();
        LocalDate firstDay = current.atDay(1);
        LocalDate lastDay = current.atDay(current.lengthOfMonth());
        for (int i = firstDay.getDayOfWeek().getValue() - 1; i > 0; i--) {
            days.add(firstDay.minusDays(i));
        }
        for (int j = 1; j < current.lengthOfMonth() + 1; j++) {
            days.add(current.atDay(j));
        }
        for (int k = 1; k < 8 - lastDay.getDayOfWeek().getValue(); k++) {
            days.add(lastDay.plusDays(k));
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
            "MMMM y",
            AbstractWebController.request.get().getLocale()
        );
        return div(CLASS + "calendar flex seven",
            h2(YearMonth.of(year, month).format(formatter)),
            forEach(days, t ->
                div(
                    span(CLASS + (t.getMonthValue() == month ? "current" : ""),
                        t.getDayOfMonth() + ""
                    )
                )
            )
        );
    }

}
