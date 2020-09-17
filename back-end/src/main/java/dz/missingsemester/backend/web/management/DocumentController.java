package dz.missingsemester.backend.web.management;

import dz.missingsemester.backend.services.CourseService;
import dz.missingsemester.backend.services.DocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/management/document")
public class DocumentController {

    private final DocumentService documentService;
    private final CourseService courseService;

    public DocumentController(DocumentService documentService,
                              CourseService courseService) {
        this.documentService = documentService;
        this.courseService = courseService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("documents", documentService.findAll());
        return "management/document/index";
    }


    @GetMapping("/upload")
    public String uploadForm(Model model) {
        model.addAttribute("courses", courseService.getAll());
        return "management/document/upload";
    }

    @PostMapping("/upload")
    public String handleUploadForm(Model model, @RequestParam("files") MultipartFile[] files,
                                   @RequestParam("course") Long courseId) {
        try {
            documentService.save(files, courseId);
        } catch (Exception ignored) {
        }
        return "redirect:/management/document/";
    }

//    @GetMapping("/download/{id}")
//    public ResponseEntity<ByteArrayResource> downloadDocument(@PathVariable("id") Long documentId) {
//        Document document = documentService.findDocumentById(documentId);
//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.parseMediaType(document.getType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
//                .body(new ByteArrayResource(document.getData()));
//    }
}
