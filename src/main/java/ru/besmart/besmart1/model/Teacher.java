package ru.besmart.besmart1.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table (name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher")
    private Integer Id;

    @Column(name = "FIO")
    private String FIO;

    @Column(name = "Avatar")
    private String Avatar;

    @Column(name = "Avatar_mini")
    private String Avatar_mini;

    @Column(name = "education")
    private String education;

    @Column(name = "about_me")
    private String about_me;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "experience")
    private String experience;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "teacher")
    private Collection<TeacherProfile> teacherProfiles;

    public Integer getId() {
        return Id;
    }
}
