package dz.missingsemester.backend.services;

import dz.missingsemester.backend.models.EducationLevel;
import dz.missingsemester.backend.repositories.EducationLevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationLevelService {
    private final EducationLevelRepository educationLevelRepository;

    public EducationLevelService(EducationLevelRepository educationLevelRepository) {
        this.educationLevelRepository = educationLevelRepository;
    }

    public EducationLevel findLevel(Long id){
        return educationLevelRepository.getOne(id);
    }

    public List<EducationLevel> getAllLevels(){
        return educationLevelRepository.findAll();
    }

    public EducationLevel save(EducationLevel educationLevel){
        return educationLevelRepository.save(educationLevel);
    }
}
