package dz.missingsemester.backend.web.management;

import dz.missingsemester.backend.services.BasicDocumentService;
import dz.missingsemester.backend.services.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/document")
public class DocumentController {

    private final BasicDocumentService basicDocumentService;
    private final CourseService courseService;

    public DocumentController(BasicDocumentService basicDocumentService,
                              CourseService courseService) {
        this.basicDocumentService = basicDocumentService;
        this.courseService = courseService;
    }

    @GetMapping("/upload")
    public String uploadForm(Model model) {
        model.addAttribute("courses", courseService.getAll());
        return "management/document/upload";
    }

    @PostMapping("/upload")
    public String handleUploadForm(Model model, @RequestParam("file") MultipartFile file[],
                                   @RequestParam("course") Long courseId) {
        try {
            basicDocumentService.save(file, courseId);
        } catch (Exception exception) {
        }
        return "redirect:/";
    }

//    @GetMapping("/download/{id}")
//    public ResponseEntity<ByteArrayResource> downloadDocument(@PathVariable("id") Long documentId) {
//        Document document = basicDocumentService.findDocumentById(documentId);
//        return ResponseEntity
//                .ok()
//                .contentType(MediaType.parseMediaType(document.getType()))
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
//                .body(new ByteArrayResource(document.getData()));
//    }
}
