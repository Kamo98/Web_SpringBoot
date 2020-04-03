package ru.besmart.besmart1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.besmart.besmart1.model.TeacherProfile;

import java.util.List;

public interface TeacherProfileRepository extends JpaRepository<TeacherProfile, Integer> {
    List<TeacherProfile> findByDiscipline_idAndPriceBetween(Integer idDiscipline, Integer priceMin, Integer priceMax);
}
