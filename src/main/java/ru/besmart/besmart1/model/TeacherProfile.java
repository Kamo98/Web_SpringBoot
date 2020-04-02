package ru.besmart.besmart1.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "teacher_profile")
public class TeacherProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private Integer Id;

    @Column(name = "active")
    private Boolean active;


    @Column(name = "is_favourite")
    private Boolean is_favourite;


    @Column(name = "price")
    private Integer price;


    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @ManyToOne(optional = false, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_discipline")
    private Discipline discipline;
}
