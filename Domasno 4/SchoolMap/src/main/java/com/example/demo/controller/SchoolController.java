package com.example.demo.controller;

import com.example.demo.model.School;
import com.example.demo.service.SchoolService;
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

    private final SchoolService schoolService;

    /**
     * Dependency injection na servisot za ucilistata
     * @param schoolService
     */
    @Autowired
    public SchoolController(SchoolService schoolService) {
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
            School school = schoolService.getSchoolById(id);
            model.addAttribute("school", school);
            return "school-single";
        } catch (RuntimeException ex) {
            return "redirect:/schools?error=" + ex.getMessage();
        }
    }
}
