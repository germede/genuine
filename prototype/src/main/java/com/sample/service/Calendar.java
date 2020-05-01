package com.sample.service;

import org.fluentness.service.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public interface Calendar extends Service {

    List<LocalDate> getDays(YearMonth month);
}
