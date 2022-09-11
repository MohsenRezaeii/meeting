package com.orange.meeting.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Calendar {
    @JsonProperty("working_hours")
    private WorkingHours workingHours;
    @JsonProperty("planned_meeting")
    private List<PlannedMeeting> plannedMeetings;

    public Calendar() {
    }

    public Calendar(WorkingHours workingHours, List<PlannedMeeting> plannedMeetings) {
        this.workingHours = workingHours;
        this.plannedMeetings = plannedMeetings;
    }

    public WorkingHours getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(WorkingHours workingHours) {
        this.workingHours = workingHours;
    }

    public List<PlannedMeeting> getPlannedMeetings() {
        return plannedMeetings;
    }

    public void setPlannedMeetings(List<PlannedMeeting> plannedMeetings) {
        this.plannedMeetings = plannedMeetings;
    }


    public int getTimeInt (String time) {
        int timeInt = Integer.parseInt(time.substring(0, 2)) * 60;
        timeInt += Integer.parseInt(time.substring(3)) ;
        return timeInt;
    }


    @Override
    public String toString() {
        return "Calendar{" +
                "workingHours=" + workingHours +
                ", plannedMeetings=" + plannedMeetings +
                '}';
    }
}
