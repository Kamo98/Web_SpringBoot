package ru.besmart.besmart1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.besmart.besmart1.model.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Integer> {
}
