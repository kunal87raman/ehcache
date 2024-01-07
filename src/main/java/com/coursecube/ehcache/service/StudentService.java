package com.coursecube.ehcache.service;

import com.coursecube.ehcache.dao.StudentRepository;
import com.coursecube.ehcache.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CacheRefreshService cacheRefreshService;

    @Cacheable(
            value = "studentCache",
            key = "#studentId"
            )
    public Student getStudentById(Long studentId){
        log.info("getStudentById from DB:"+studentId);
        return studentRepository.findStudentByStudentId(studentId);
    }

    public void updateStudentCache(Student student){
        cacheRefreshService.refreshCache(student);
        log.info("Cache refreshed for studentId :"+student.getStudentId());
    }
}
