package com.orange.meeting.demo;

import com.orange.meeting.demo.dto.*;
import com.orange.meeting.demo.dto.Calendar;
import com.orange.meeting.demo.service.MeetingService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
class DemoApplicationTests {
    private static Request request;
    private static Output output;

    private static List<String[]> results;
    private static WorkingHours workingHours;
    private static PlannedMeeting plannedMeeting;
    private static List<PlannedMeeting> plannedMeetings;
    private static Calendar calendar;
    private static int duration;

    private static MeetingService meetingService;
    @BeforeAll
    static void before() {
        duration = 30;
        meetingService = new MeetingService();
        request = new Request();
        plannedMeetings = new ArrayList<>();
        calendar = new Calendar();
        workingHours = new WorkingHours("08:00" , "16:00");
        calendar.setWorkingHours(workingHours);
        plannedMeeting = new PlannedMeeting("10:30" , "11:00");
        plannedMeetings.add(plannedMeeting);
        plannedMeeting = new PlannedMeeting("11:30" , "12:00");
        plannedMeetings.add(plannedMeeting);
        calendar.setPlannedMeetings(plannedMeetings);
        request.setCalendar1(calendar);

        plannedMeetings = new ArrayList<>();
        calendar = new Calendar();
        workingHours = new WorkingHours("08:00" , "17:00");
        calendar.setWorkingHours(workingHours);
        plannedMeeting = new PlannedMeeting("09:30" , "10:40");
        plannedMeetings.add(plannedMeeting);
        plannedMeeting = new PlannedMeeting("14:30" , "16:00");
        plannedMeetings.add(plannedMeeting);
        calendar.setPlannedMeetings(plannedMeetings);
        request.setCalendar2(calendar);

        output = meetingService.findMeeting(request);
        results = output.getResults();
    }

    @Test
    void contextLoads() {
        String[] expectedResult1 = {"08:00", "09:30"};
        String[] expectedResult2 = {"12:00", "14:30"};
        List<String []> expectedResults = new ArrayList<>();
        expectedResults.add(expectedResult1);
        expectedResults.add(expectedResult2);
        assertArrayEquals(expectedResults.toArray(), results.toArray());
    }

}
