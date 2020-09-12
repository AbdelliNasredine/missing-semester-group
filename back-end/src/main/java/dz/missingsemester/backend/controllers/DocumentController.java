package dz.missingsemester.backend.controllers;

import dz.missingsemester.backend.services.BasicDocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/document")
public class DocumentController {

    private final BasicDocumentService basicDocumentService;

    public DocumentController(BasicDocumentService basicDocumentService) {
        this.basicDocumentService = basicDocumentService;
    }

//    @GetMapping("/upload")
//    public String uploadForm(Model model) {
//        return "upload/index";
//    }
//
//    @PostMapping("/upload")
//    public String handleUploadForm(Model model, @RequestParam("file") MultipartFile file) {
//        try {
//            basicDocumentService.save(file);
//        } catch (Exception exception) {
//        }
//        return "redirect:/";
//    }
//
//    @GetMapping("/download/{id}")
//    public ResponseEntity<ByteArrayResource> downloadDocument(@PathVariable("id") Long documentId){
//        Document document = basicDocumentService.findDocumentById(documentId);
//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.parseMediaType(document.getType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
//                .body(new ByteArrayResource(document.getData()));
//    }
}
