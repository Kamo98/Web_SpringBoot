package ru.besmart.besmart1.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.besmart.besmart1.model.Discipline;
import ru.besmart.besmart1.model.FilterTeachForm;
import ru.besmart.besmart1.model.TeacherProfile;
import ru.besmart.besmart1.service.TeacherService;

import java.util.List;

@Controller
public class TeacherProfileController {
    @Autowired
    private TeacherService teacherServ;


    @GetMapping("/")
    public String main(Model model) {
        List<TeacherProfile> teacherProfiles = teacherServ.getAllTeachProf();
        List<Discipline> disciplines = teacherServ.getAllDiscipline();
        FilterTeachForm filterTeachForm = new FilterTeachForm();

        model.addAttribute("teacherProfiles", teacherProfiles);
        model.addAttribute("disciplines", disciplines);
        model.addAttribute("filterTeachForm", filterTeachForm);
        return "main";
    }


    //Для приёма post от формы фильтрации
    @PostMapping("/")
    public String mainFilter(FilterTeachForm filterTeachForm, Model model) {
        String price[] = filterTeachForm.getPrice().split("-");
        Integer priceMin = Integer.parseInt(price[0]);
        Integer priceMax = Integer.parseInt(price[1]);

        List<TeacherProfile> teacherProfiles = teacherServ.filterTeachProf(filterTeachForm.getIdDiscipline(), priceMin, priceMax);
        List<Discipline> disciplines = teacherServ.getAllDiscipline();

        model.addAttribute("teacherProfiles", teacherProfiles);
        model.addAttribute("disciplines", disciplines);
        return "main";
    }
}
