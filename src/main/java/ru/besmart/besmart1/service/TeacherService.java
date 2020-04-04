package ru.besmart.besmart1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.besmart.besmart1.model.Discipline;
import ru.besmart.besmart1.model.Teacher;
import ru.besmart.besmart1.model.TeacherProfile;
import ru.besmart.besmart1.repository.DisciplineRepository;
import ru.besmart.besmart1.repository.TeacherProfileRepository;
import ru.besmart.besmart1.repository.TeacherRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherProfileRepository teacherProfileRep;

    @Autowired
    private DisciplineRepository disciplineRep;

    @Autowired
    private TeacherRepository teacherRep;

    //Найти анкету по id
    public TeacherProfile findProfileById(Integer id) {
        return teacherProfileRep.getOne(id);
    }

    //Найти преподавателя по id
    public Teacher findTeacherById(Integer id) {
        return teacherRep.getOne(id);
    }

    //Вернуть все анкеты
    public List<TeacherProfile> getAllTeachProf(){
        return teacherProfileRep.findAll();
    }


    //Фильтрация анкет по цене и дисциплине
    public List<TeacherProfile> filterTeachProf(Integer idDisc, Integer priceMin, Integer priceMax) {
        return teacherProfileRep.findByDiscipline_idAndPriceBetween(idDisc, priceMin, priceMax);
    }

    //Сохранение анкеты
    public void saveTeacherProfile (TeacherProfile teacherProfile) {
        teacherProfileRep.save(teacherProfile);
    }

    //Сохранение преподавателя
    public void saveTeacher(Teacher teacher) {
        teacherRep.save(teacher);
    }

    //Удаление анкеты по id
    public void deleteById(Integer id) {
        teacherProfileRep.deleteById(id);
    }

    public List<Discipline> getAllDiscipline() {
        return disciplineRep.findAll();
    }
}
