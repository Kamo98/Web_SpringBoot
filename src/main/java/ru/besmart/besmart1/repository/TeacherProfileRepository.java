package ru.besmart.besmart1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.besmart.besmart1.model.TeacherProfile;

public interface TeacherProfileRepository extends JpaRepository<TeacherProfile, Integer> {

}
