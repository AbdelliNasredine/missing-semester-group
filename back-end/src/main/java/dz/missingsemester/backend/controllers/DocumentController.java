package dz.missingsemester.backend.controllers;

import dz.missingsemester.backend.models.Document;
import dz.missingsemester.backend.services.DocumentService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/document")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/upload")
    public String uploadForm(Model model) {
        return "upload/index";
    }

    @PostMapping("/upload")
    public String handleUploadForm(Model model, @RequestParam("file") MultipartFile file) {
        try {
            documentService.save(file);
        } catch (Exception exception) {
        }
        return "redirect:/";
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> downloadDocument(@PathVariable("id") Long documentId){
        Document document = documentService.findDocumentById(documentId);
        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(document.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
                .body(new ByteArrayResource(document.getData()));
    }
}
