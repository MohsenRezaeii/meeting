package com.orange.meeting.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {
    @JsonProperty("calendar_1")
    private Calendar calendar1;
    @JsonProperty("calendar_2")
    private Calendar calendar2;

    public Calendar getCalendar1() {
        return calendar1;
    }

    public void setCalendar1(Calendar calendar1) {
        this.calendar1 = calendar1;
    }

    public Calendar getCalendar2() {
        return calendar2;
    }

    public void setCalendar2(Calendar calendar2) {
        this.calendar2 = calendar2;
    }
}
