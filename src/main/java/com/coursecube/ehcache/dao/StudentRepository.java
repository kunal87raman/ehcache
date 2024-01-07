package com.coursecube.ehcache.dao;

import com.coursecube.ehcache.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {

    public Student findStudentByStudentId(Long studentId);

}
