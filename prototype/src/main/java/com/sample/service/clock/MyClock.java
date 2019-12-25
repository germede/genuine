package com.sample.service.clock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyClock implements Clock {

    @Override
    public String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    }

}
