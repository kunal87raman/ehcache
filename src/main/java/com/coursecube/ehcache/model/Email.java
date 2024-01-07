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
@Table(name="EMAIL_DETAILS")
public class Email implements Serializable {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "STUDENT_ID")
    private Long studentId;

    @Column(name = "EMAIL_ID")
    private String emailId;

    public Email(Long id, String emailId) {
        this.id = id;
        this.emailId = emailId;
    }
}
