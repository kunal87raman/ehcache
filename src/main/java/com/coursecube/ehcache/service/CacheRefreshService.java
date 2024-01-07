package com.coursecube.ehcache.service;

import com.coursecube.ehcache.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class CacheRefreshService {

//    @Autowired
//    @Qualifier("ehCacheManager")
//    private FactoryBean<CacheManager> ehCacheManagerFactory;

    @Autowired
    CacheManager cacheManager;

    public void refreshCache(Student student){
        try {
            //CacheManager cacheManager = ehCacheManagerFactory.getObject();

            Cache ehcache = cacheManager.getCache("studentCache");
            Long studentId = student.getStudentId();
            if(ehcache.get(studentId) != null){
                ehcache.put(studentId,student);
                log.info("Updated Student with id :"+studentId);
            }
            else {
                ehcache.put(studentId,student);
                log.info("Created new Student with id :"+studentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
