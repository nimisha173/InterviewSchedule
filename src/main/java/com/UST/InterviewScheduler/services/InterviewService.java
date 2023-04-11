package com.UST.InterviewScheduler.services;

import com.UST.InterviewScheduler.entity.Interview;
import com.UST.InterviewScheduler.repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {
    @Autowired
    private InterviewRepository repo;





    public List<Interview> getInterview() {
        return repo.findAll();
    }


    public Interview getInterviewById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Interview createInterview(Interview interview) {
        return repo.save(interview);
    }
}
