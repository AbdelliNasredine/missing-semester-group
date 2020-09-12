package dz.missingsemester.backend.repositories;

import dz.missingsemester.backend.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
