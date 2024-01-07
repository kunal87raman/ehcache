package com.coursecube.ehcache.controller;

import com.coursecube.ehcache.model.Course;
import com.coursecube.ehcache.model.Email;
import com.coursecube.ehcache.model.Student;
import com.coursecube.ehcache.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudent")
    public ResponseEntity getStudentById(@RequestParam  Long studentId){
        Student student = studentService.getStudentById(studentId);
        log.info("Received student with name as {} for studentId {}", student.getSname(),studentId);
        if(student != null)
            return ResponseEntity.ok(student);
        else
            return ResponseEntity.badRequest().body("No student found !");

    }

    @PostMapping("/update/{studentId}")
    public ResponseEntity updateStudentObjects(@PathVariable Long studentId){
        Student student = new Student(studentId, "kunal","+9177777777777", LocalDateTime.now());
        Email email = new Email(1L,"kunal7rock@gmail.com");
        email.setStudentId(studentId);
        List<Email> emailList = new ArrayList<>();
        emailList.add(email);
        student.setEmails(emailList);
        Course course = new Course(1L,"REACTJS","SRINIVAS DANDE");
        course.setStudentId(studentId);
        List<Course> courseList = new ArrayList<>();
        courseList.add(course);
        student.setCourses(courseList);

        studentService.updateStudentCache(student);
        return ResponseEntity.ok().build();
    }
}
