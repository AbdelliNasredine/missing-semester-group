package dz.missingsemester.backend.repositories;

import dz.missingsemester.backend.models.EducationLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationLevelRepository extends JpaRepository<EducationLevel, Long> {
}
