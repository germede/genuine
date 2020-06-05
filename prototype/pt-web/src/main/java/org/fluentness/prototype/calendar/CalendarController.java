package org.fluentness.prototype.calendar;

import org.fluentness.controller.view.AbstractWebViewController;

public class CalendarController extends AbstractWebViewController<CalendarView> {

    public CalendarController(CalendarView view) {
        super(view, "/calendar");
        onClick(view.button1, this::doNothing);
        onClick(view.button2, this::doSomething);
    }

    private void doSomething() {
        System.out.println("TEST");
    }

    private void doNothing() {
        view.button1.setText("HA!");
        view.root.appendChild(view.button1);
    }

}


//package org.fluentness.prototype.controller;
//
//import org.fluentness.prototype.view.WebView;
//import org.fluentness.controller.AbstractWebController;
//import org.fluentness.service.dispatcher.ActionDispatcher;
//import org.fluentness.view.container.HtmlContainer;
//
//import java.time.LocalDate;
//import java.time.YearMonth;
//import java.time.format.DateTimeFormatter;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Locale;
//
//import static org.fluentness.view.AbstractWebView.*;
//import static org.fluentness.view.component.HtmlAttribute.CLASS;
//import static org.fluentness.view.component.HtmlAttribute.HREF;
//
//public class WebCalendarController extends AbstractWebController<WebView> {
//
//    public WebCalendarController(WebView web, ActionDispatcher dispatcher) {
//        super(web, dispatcher);
//    }
//
//    @Action(path = "/calendar")
//    HtmlContainer calendar(int year, int month) {
//        YearMonth current = (year == 0 && month == 0) ? YearMonth.now() : YearMonth.of(year, month);
//        YearMonth previous = current.minusMonths(1);
//        YearMonth next = current.plusMonths(1);
//        List<LocalDate> days = getDays(current);
//        return div(CLASS + "calendar",
//            header(
//                h2(
//                    i(CLASS + "icono-calendar"),
//                    current.format(DateTimeFormatter.ofPattern("MMMM y", Locale.getDefault()))
//                ),
//                div(CLASS + "right",
//                    a(HREF + "/calendar/month?year=" + previous.getYear() + "&month=" + previous.getMonthValue(),
//                        i(CLASS + "icono-caretLeftCircle")
//                    ),
//                    a(HREF + "/calendar/month?year=" + next.getYear() + "&month=" + next.getMonthValue(),
//                        i(CLASS + "icono-caretRightCircle")
//                    )
//                )
//            ),
//            div(CLASS + "flex seven",
//                forEach(days, day ->
//                    span(CLASS + (day.getMonthValue() == current.getMonthValue() ? "current" : ""),
//                        day.getDayOfMonth() + ""
//                    )
//                )
//            )
//        );
//    }
//
//    private List<LocalDate> getDays(YearMonth month) {
//        List<LocalDate> days = new LinkedList<>();
//        LocalDate firstDay = month.atDay(1);
//        LocalDate lastDay = month.atDay(month.lengthOfMonth());
//
//        for (int i = firstDay.getDayOfWeek().getValue() - 1; i > 0; i--) {
//            days.add(firstDay.minusDays(i));
//        }
//        for (int j = 1; j < month.lengthOfMonth() + 1; j++) {
//            days.add(month.atDay(j));
//        }
//        for (int k = 1; k < 8 - lastDay.getDayOfWeek().getValue(); k++) {
//            days.add(lastDay.plusDays(k));
//        }
//        return days;
//    }
//
//}