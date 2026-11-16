package com.example.course_access_gateway.Service;

import com.example.course_access_gateway.Entity.Course;
import com.example.course_access_gateway.Repository.CourseRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {
    CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo){
        this.courseRepo =courseRepo;
    }

    //Add
    public Course addCourseToDb(Course course){
        return courseRepo.save(course);
    }

    //Get by ID
    public Course getCourseByDb(Long id){
        Course course = courseRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

        return course;
    }

    //Get All
    public List<Course> getAllCourseByDb(){
        List<Course> courses = courseRepo.findAll();

        return courses;
    }

    //Update
    @Transactional
    public Course updateCourseToDb(Long id, Course course){
       Course originalCourse = courseRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));

       originalCourse.setDescription(course.getDescription());
       originalCourse.setTitle(course.getTitle());
       originalCourse.setPrice(course.getPrice());
       originalCourse.setInstructorName(course.getInstructorName());

       return  originalCourse;
    }

    //Delete
    @Transactional
    public void deleteCourse(Long id){
        Course toDelete = courseRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        courseRepo.delete(toDelete);
    }
}
