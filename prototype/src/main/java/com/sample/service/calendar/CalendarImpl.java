package com.sample.service.calendar;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.LinkedList;
import java.util.List;

public class CalendarImpl implements Calendar {

    @Override
    public List<LocalDate> getDays(YearMonth month) {

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
