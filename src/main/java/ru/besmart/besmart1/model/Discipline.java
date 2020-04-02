package ru.besmart.besmart1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table (name = "discipline")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_discipline")
    private Integer Id;

    @Column(name = "Name")
    private String Name;

    @OneToMany(mappedBy = "discipline")
    private Collection<TeacherProfile> teacherProfiles;
}
