package com.orange.meeting.demo.dto;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class WorkingHours {
    private String start;
    private String end;

    public WorkingHours(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public LocalTime getStartTime()  {
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        Time timeValue = null;
        try {
            timeValue = new Time(formatter.parse(this.start).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeValue.toLocalTime();
    }
    public LocalTime getEndTime() {
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        Time timeValue = null;
        try {
            timeValue = new Time(formatter.parse(this.end).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeValue.toLocalTime();
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "WorkingHours{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
