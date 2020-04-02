package ru.besmart.besmart1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.besmart.besmart1.model.TeacherProfile;
import ru.besmart.besmart1.repository.TeacherProfileRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class TeacherProfileService {
    @Autowired
    private TeacherProfileRepository teacherProfileRep;

    //Найти анкету по id
    public TeacherProfile findById(Integer id) {
        return teacherProfileRep.getOne(id);
    }

    //Вернуть все анкеты
    public List<TeacherProfile> findAll(){
        return teacherProfileRep.findAll();
    }

    //Сохранение анкеты
    public void saveTeacherProfile (TeacherProfile teacherProfile) {
        teacherProfileRep.save(teacherProfile);
    }

    //Удаление анкеты по id
    public void deleteById(Integer id) {
        teacherProfileRep.deleteById(id);
    }
}
