package com.coursecube.ehcache.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name="STUDENT")
public class Student implements Serializable {

    @Id
    @Column(name = "STUDENT_ID")
    private Long studentId;

    @Column(name = "STUDENT_NAME")
    private String sname;

    @Column(name = "STUDENT_PHONE")
    private String phone;

    @Column(name = "UPDATED_TIME")
    private LocalDateTime updated_time;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "STUDENT_ID")
    private List<Email> emails;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "STUDENT_ID")
    private List<Course> courses;

    public Student(Long studentId, String sname, String phone, LocalDateTime updated_time) {
        this.studentId = studentId;
        this.sname = sname;
        this.phone = phone;
        this.updated_time = updated_time;
    }
}
