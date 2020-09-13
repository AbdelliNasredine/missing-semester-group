package dz.missingsemester.backend.web.management;


import dz.missingsemester.backend.services.CourseService;
import dz.missingsemester.backend.services.EducationLevelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("management/courses")
public class CourseController {

    private final CourseService courseService;
    private final EducationLevelService educationLevelService;

    public CourseController(CourseService courseService, EducationLevelService educationLevelService) {
        this.courseService = courseService;
        this.educationLevelService = educationLevelService;
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("levels", educationLevelService.getAllLevels());
        return "management/course/add";
    }

    @PostMapping("/add")
    public String handle(@RequestParam("name") String courseName, @RequestParam("level") Long levelId){
        courseService.save(courseName, levelId);
        return "redirect:/management/courses/add";
    }
}
