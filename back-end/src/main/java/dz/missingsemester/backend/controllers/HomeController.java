package dz.missingsemester.backend.controllers;

import dz.missingsemester.backend.services.DocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final DocumentService documentService;

    public HomeController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping({"index", ""})
    public String index(Model model){
        model.addAttribute("documents", documentService.getAll());
        return "index";
    }
}
