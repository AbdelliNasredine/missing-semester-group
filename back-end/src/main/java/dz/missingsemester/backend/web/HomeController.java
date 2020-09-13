package dz.missingsemester.backend.web;

import dz.missingsemester.backend.services.BasicDocumentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final BasicDocumentService basicDocumentService;

    public HomeController(BasicDocumentService basicDocumentService) {
        this.basicDocumentService = basicDocumentService;
    }

    @GetMapping({"index", ""})
    public String index(Model model){
//        model.addAttribute("documents", basicDocumentService.getAll());
        return "management/index";
    }
}
