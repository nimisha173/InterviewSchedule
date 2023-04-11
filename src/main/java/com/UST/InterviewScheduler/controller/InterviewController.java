package com.UST.InterviewScheduler.controller;

import com.UST.InterviewScheduler.entity.Interview;
import com.UST.InterviewScheduler.services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/h")
public class InterviewController {
    @Autowired
    private InterviewService interviewService;
    @PostMapping("/schedule")
    public Interview addInterview(@RequestBody Interview interview) {
        return interviewService.createInterview(interview);
    }
    @GetMapping("/interviewer")
    public List<Interview> getAllInterview() {
        return interviewService.getInterview();
    }
    @GetMapping("/interviewer/{id}")
    public Interview getInterviewById(@PathVariable int id) {

        return interviewService.getInterviewById(id);
    }

}
