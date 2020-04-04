package ru.besmart.besmart1.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.besmart.besmart1.model.Discipline;
import ru.besmart.besmart1.model.FilterTeachForm;
import ru.besmart.besmart1.model.Teacher;
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
        if (teacherProfiles.size() == 0)
            teacherProfiles = null;

        List<Discipline> disciplines = teacherServ.getAllDiscipline();

        model.addAttribute("teacherProfiles", teacherProfiles);
        model.addAttribute("disciplines", disciplines);
        return "main";
    }


    //Страница с одним преподавателем
    @GetMapping("/teacher/{id}")
    public String getTeacher(@PathVariable("id") Integer id, Model model) {
        Teacher teacher = teacherServ.findTeacherById(id);
        model.addAttribute("teacher", teacher);
        return "teacher";
    }



    @GetMapping("/admin")
    public String mainAdmin(Model model) {
        List<TeacherProfile> teacherProfiles = teacherServ.getAllTeachProf();
        List<Discipline> disciplines = teacherServ.getAllDiscipline();
        FilterTeachForm filterTeachForm = new FilterTeachForm();

        model.addAttribute("teacherProfiles", teacherProfiles);
        model.addAttribute("disciplines", disciplines);
        model.addAttribute("filterTeachForm", filterTeachForm);
        return "mainAdmin";
    }


    @GetMapping("/delete/{id}")
    public String deleteProfile(@PathVariable("id") Integer id) {
        teacherServ.deleteById(id);
        return "redirect:/admin";
    }


    @GetMapping("/update/{id}")
    public String updateTeachForm(@PathVariable("id") Integer id, Model model) {
        Teacher teacher = teacherServ.findTeacherById(id);
        model.addAttribute("teacher", teacher);

        List<Discipline> disciplines = teacherServ.getAllDiscipline();
        model.addAttribute("disciplines", disciplines);

        return "update";
    }

    @PostMapping("/update")
    public String updateTeach(Teacher teacher, Model model) {
        teacherServ.saveTeacher(teacher);
        List<Discipline> disciplines = teacherServ.getAllDiscipline();
        model.addAttribute("disciplines", disciplines);

        return "redirect:/admin";
        //return "redirect:/update/" + teacher.getId();
    }
}
