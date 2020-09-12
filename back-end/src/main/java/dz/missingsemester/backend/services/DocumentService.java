package dz.missingsemester.backend.services;

import dz.missingsemester.backend.models.Document;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DocumentService {
    public List<Document> findDocumentsByCourse(Long courseId);
    public void save(MultipartFile[] files, Long courseId);
}
