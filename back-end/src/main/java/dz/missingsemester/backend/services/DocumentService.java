package dz.missingsemester.backend.services;

import dz.missingsemester.backend.models.Document;
import dz.missingsemester.backend.repositories.DocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document save(MultipartFile file) throws Exception{
        String name = file.getOriginalFilename();
        String type = file.getContentType();
        byte[] data = file.getBytes();
        Document document = new Document(name, type, data);
        return documentRepository.save(document);
    }

    public List<Document> getAll(){
        return documentRepository.findAll();
    }

    public Document findDocumentById(Long id){
        Optional<Document> documentOptional = documentRepository.findById(id);
        return documentOptional.get();
    }
}
