package com.orange.meeting.demo.service;

import com.orange.meeting.demo.dto.Calendar;
import com.orange.meeting.demo.dto.Output;
import com.orange.meeting.demo.dto.PlannedMeeting;
import com.orange.meeting.demo.dto.Request;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MeetingService {

    public Output findMeeting(Request request) {

        Integer meetingTime = 10;

        List<LocalTime[]> results = new ArrayList<>();
        Calendar calendar1 = request.getCalendar1();
        Calendar calendar2 = request.getCalendar2();
        List<PlannedMeeting> freeTime1 = calFreeTime(calendar1);
        List<PlannedMeeting> freeTime2 = calFreeTime(calendar2);

        freeTime1.forEach(plannedMeeting -> {
            freeTime2.forEach(
                    plannedMeeting2 -> {
                        if (
                                plannedMeeting2.getStartTime().compareTo(plannedMeeting.getStartTime()) >= 0 && plannedMeeting2.getStartTime().compareTo(plannedMeeting.getEndTime()) <= 0
                                        || plannedMeeting2.getEndTime().compareTo(plannedMeeting.getStartTime()) >= 0 && plannedMeeting2.getEndTime().compareTo(plannedMeeting.getEndTime()) <= 0
                        ) {
                            LocalTime endTime = plannedMeeting2.getEndTime().compareTo(plannedMeeting.getEndTime()) <= 0 ? plannedMeeting2.getEndTime() : plannedMeeting.getEndTime();
                            LocalTime startTime = plannedMeeting2.getStartTime().compareTo(plannedMeeting.getStartTime()) >= 0 ? plannedMeeting2.getStartTime() : plannedMeeting.getStartTime();
                            if (startTime.plusMinutes(meetingTime).compareTo(endTime) <= 0) {
                                results.add(new LocalTime[]{startTime, endTime});
                            }
                        }
                    }
            );
        });


        Output output = new Output();
        output.setResults(results.stream().map(r -> new String[]{r[0].toString(), r[1].toString()}).collect(Collectors.toList()));
        for (String[] result : output.getResults()) {
            System.out.println(Arrays.toString(result));
        }
        ;
        return output;
    }

    private List<PlannedMeeting> calFreeTime(Calendar calendar) {
        List<PlannedMeeting> freeTime = new ArrayList<>();
        freeTime.add(new PlannedMeeting(calendar.getWorkingHours().getStart(), calendar.getPlannedMeetings().get(0).getStart()));
        List<PlannedMeeting> plannedMeetings = calendar.getPlannedMeetings();
        for (int i = 1; i < plannedMeetings.size(); i++) {
            freeTime.add(new PlannedMeeting(plannedMeetings.get(i - 1).getEnd(), plannedMeetings.get(i).getStart()));
        }
        if (plannedMeetings.size() > 1) {
            freeTime.add(new PlannedMeeting(plannedMeetings.get(plannedMeetings.size() - 1).getEnd(), calendar.getWorkingHours().getEnd()));
        }
        return freeTime;
    }
}
