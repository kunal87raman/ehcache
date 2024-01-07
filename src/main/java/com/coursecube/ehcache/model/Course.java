package com.coursecube.ehcache.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity
@Table(name="COURSE")
public class Course implements Serializable {

    @Id
    @Column(name = "COURSE_ID")
    private Long courseId;

    @Column(name = "STUDENT_ID")
    private Long studentId;

    @Column(name = "COURSE_NAME")
    private String cname;

    @Column(name = "TRAINER")
    private String trainer;

    public Course(Long courseId, String cname, String trainer) {
        this.courseId = courseId;
        this.cname = cname;
        this.trainer = trainer;
    }
}
