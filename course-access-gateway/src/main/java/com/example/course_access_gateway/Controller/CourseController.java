package com.example.course_access_gateway.Controller;


import com.example.course_access_gateway.Entity.Course;
import com.example.course_access_gateway.Service.CourseService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    CourseService courseService;

    public CourseController (CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourse(){

        return ResponseEntity.status(201).body(courseService.getAllCourseByDb());
    }

    @GetMapping
    public ResponseEntity<Course> getCourseById(@PathVariable Long id){
        return ResponseEntity.ok(courseService.getCourseByDb(id));
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course ){
        return ResponseEntity.ok(courseService.addCourseToDb(course));
    }

    @PutMapping
    public ResponseEntity<Course> updateCourse(@PathVariable Long id,
                                               @RequestBody Course course ){
        return ResponseEntity.ok(courseService.updateCourseToDb(id, course));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCourse(@PathVariable Long id ){
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Entity Deleted Successfully...");
    }
}
