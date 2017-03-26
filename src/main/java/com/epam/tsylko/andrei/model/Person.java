package com.epam.tsylko.andrei.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;


@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 7045624739259564914L;
    @Id
    @GeneratedValue
    private int id;

    @Size(min = 1, max = 150, message = "В фамилии должно быть от 1 до 150 символов")
    @Pattern(regexp = "[a-zA-Z_0-9А-яЁё-]{1,150}", message = "Фамилия может состоять из букв, цифр, знаков подчёркивания и знаков минус")
    private String surname;

    @Size(min = 1, max = 150, message = "В имени должно быть от 1 до 150 символов")
    @Pattern(regexp = "[a-zA-Z_0-9А-яЁё-]{1,150}", message = "Имя может состоять из букв, цифр, знаков подчёркивания и знаков минус")
    private String name;

    @Size(min = 1, max = 150, message = "В отчестве должно быть от 1 до 150 символов")
    @Pattern(regexp = "[a-zA-Z_0-9А-яЁё-]{1,150}", message = "Отчество может состоять из букв, цифр, знаков подчёркивания и знаков минус")
    private String middlename;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Phone> phones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }


}
