package com.emily.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
            new Course(1,"Learn AWS","emily"),
            new Course(2,"Learn DevOps","emily"),
            new Course(3,"learn Azure","emily")
        );
    }
}
