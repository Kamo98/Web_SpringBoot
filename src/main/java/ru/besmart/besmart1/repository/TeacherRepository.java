package ru.besmart.besmart1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.besmart.besmart1.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
