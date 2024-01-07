package com.coursecube.ehcache.controller;

import com.coursecube.ehcache.service.NumberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/number")
public class NumberController {

    @Autowired
    private NumberService numberService;

    @GetMapping(path = "/square/{mynumber}")
    public String getSquare(@PathVariable Long mynumber) {
        log.info("call numberService to square {}", mynumber);
        return String.format("{\"square\": %s}", numberService.square(mynumber));
    }


}
