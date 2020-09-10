package dz.missingsemester.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @GetMapping
    public String uploadForm() {
        return "upload/index";
    }

    @PostMapping
    public String handleUploadForm() {
        return "redirect:/upload";
    }
}
