package com.orange.meeting.demo.controller;

import com.orange.meeting.demo.dto.Output;
import com.orange.meeting.demo.dto.Request;
import com.orange.meeting.demo.service.MeetingService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    private final MeetingService meetingService;

    public MainController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @PostMapping("find-match")
    public Output  findMeeting(@RequestBody Request request){
        return meetingService.findMeeting(request);
    }
}
