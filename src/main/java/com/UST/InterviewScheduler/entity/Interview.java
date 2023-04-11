package com.UST.InterviewScheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interview {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String emailid;
    private String phno;
    private String skills;
    private int experience;
    private Date date;
    private String time;
    private String link;
    private String poc;

}
