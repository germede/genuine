package com.sample.service;

import org.fluentness.controller.web.template.html.Html;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.LinkedList;
import java.util.List;

import static org.fluentness.controller.web.template.html.HtmlAttribute.CLASS;
import static org.fluentness.controller.web.template.html.HtmlFactory.*;

public class CalendarServiceImpl implements CalendarService {

    @Override
    public Html renderMonthCalendar(int year, int month) {
        YearMonth of = YearMonth.of(year, month);
        List<LocalDate> days = new LinkedList<>();
        for (int i = 1; i < of.lengthOfMonth() +1; i++) {
            days.add(of.atDay(i));
        }
        return div(CLASS + "flex seven",
            forEach(days, t -> div(span(t+"")))
        );
    }

}
