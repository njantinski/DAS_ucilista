package com.example.demo;

import com.example.demo.model.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/schools")
public class SchoolController {

    private SchoolServiceImpl schoolService;

    @Autowired
    public SchoolController(SchoolServiceImpl schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public String getSchools(Model model){
        List<School> schoolList = schoolService.getSchools();
        model.addAttribute("schools",schoolList);
        return "schools";
    }

    @GetMapping("/{id}")
    public String showSchool(Model model,@PathVariable Long id){
        try{
            School school = schoolService.getById(id);
            model.addAttribute("school", school);
            return "school-single";
        } catch (RuntimeException ex) {
            return "redirect:/products?error=" + ex.getMessage();
        }
    }
}
