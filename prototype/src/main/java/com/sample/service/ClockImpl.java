package com.sample.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockImpl implements Clock {

    @Override
    public String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }

}
