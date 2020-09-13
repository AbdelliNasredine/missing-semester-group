package dz.missingsemester.backend.services;

import dz.missingsemester.backend.models.Course;
import dz.missingsemester.backend.models.EducationLevel;
import dz.missingsemester.backend.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final EducationLevelService educationLevelService;

    public CourseService(CourseRepository courseRepository, EducationLevelService educationLevelService) {
        this.courseRepository = courseRepository;
        this.educationLevelService = educationLevelService;
    }

    public List<Course> getAll(){
        return courseRepository.findAll();
    }

    public Course save(String courseName, Long levelId){
        EducationLevel level = educationLevelService.findLevel(levelId);
        Course course = new Course(courseName, level);
        return courseRepository.save(course);
    }
}
