package dz.missingsemester.backend.services;

import dz.missingsemester.backend.models.Course;
import dz.missingsemester.backend.models.Document;
import dz.missingsemester.backend.repositories.CourseRepository;
import dz.missingsemester.backend.repositories.DocumentRepository;
import dz.missingsemester.backend.repositories.EducationLevelRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BasicDocumentService implements DocumentService{
    private final DocumentRepository documentRepository;
    private final EducationLevelRepository educationLevelRepository;
    private final CourseRepository courseRepository;

    public BasicDocumentService(DocumentRepository documentRepository, EducationLevelRepository educationLevelRepository, CourseRepository courseRepository) {
        this.documentRepository = documentRepository;
        this.educationLevelRepository = educationLevelRepository;
        this.courseRepository = courseRepository;
    }

    private Document saveOne(MultipartFile file, Course course) throws IOException {
        String name = file.getOriginalFilename();
        String type = file.getContentType();
        byte[] data = file.getBytes();
        Document document = new Document(name, type, data, course);
        return documentRepository.save(document);
    }

    @Override
    public List<Document> findDocumentsByCourse(Long courseId) {
        return courseRepository.getOne(courseId).getDocuments();
    }

    @Override
    public void save(MultipartFile[] files, Long courseId){
        Course course = courseRepository.getOne(courseId);
        for (MultipartFile file : files){
            try {
                saveOne(file, course);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
