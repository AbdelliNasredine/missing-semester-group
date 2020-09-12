package dz.missingsemester.backend.services;

import dz.missingsemester.backend.models.EducationLevel;
import dz.missingsemester.backend.repositories.EducationLevelRepository;

import java.util.List;

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
}
