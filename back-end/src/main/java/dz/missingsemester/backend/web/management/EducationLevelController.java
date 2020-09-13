package dz.missingsemester.backend.web.management;

import dz.missingsemester.backend.models.EducationLevel;
import dz.missingsemester.backend.services.EducationLevelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/management/levels")
public class EducationLevelController {

    private final EducationLevelService educationLevelService;

    public EducationLevelController(EducationLevelService educationLevelService) {
        this.educationLevelService = educationLevelService;
    }

    @GetMapping("/add")
    public String addForm(){
        return "management/level/add";
    }

    @PostMapping("/add")
    public String handleAdd(Model model, @RequestParam("name") String name){
        EducationLevel educationLevel = new EducationLevel(name);
        educationLevel = educationLevelService.save(educationLevel);
        model.addAttribute("success_message",
                String.format("level with id %s has been added", educationLevel.getId()));
        return "redirect:/management/levels/add";
    }
}
