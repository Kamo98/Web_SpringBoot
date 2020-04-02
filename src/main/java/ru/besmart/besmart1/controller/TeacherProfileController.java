package ru.besmart.besmart1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.besmart.besmart1.model.TeacherProfile;
import ru.besmart.besmart1.service.TeacherProfileService;

import java.util.List;

@Controller
public class TeacherProfileController {
    @Autowired
    private TeacherProfileService teacherProfileServ;

    @GetMapping("/")
    public String main(Model model) {
        List<TeacherProfile> teacherProfiles = teacherProfileServ.findAll();

        model.addAttribute("teacherProfiles", teacherProfiles);
        return "main";
    }
}
