package com.UST.InterviewScheduler.repository;

import com.UST.InterviewScheduler.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Integer> {



}
