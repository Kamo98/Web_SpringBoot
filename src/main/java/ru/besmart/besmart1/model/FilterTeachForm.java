package ru.besmart.besmart1.model;

import lombok.Data;
import lombok.Getter;

@Data
public class FilterTeachForm {
    public Integer getIdDiscipline() {
        return idDiscipline;
    }

    private Integer idDiscipline;
    private String price;

    public String getPrice() {
        return price;
    }
}
