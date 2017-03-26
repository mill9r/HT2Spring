package com.epam.tsylko.andrei.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
public class Phone implements Serializable{

    private static final long serialVersionUID = -7504003386400120423L;
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn (name = "owner")
    private Person owner;

    @Size(min = 1, max = 50, message = "В номере телефона может быть от 2 до 50 символов")
    @Pattern(regexp = "[_0-9-+#]{2,50}", message = "Номер телефона может состоять из цифр и знаков: +, #, -")
    private String number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
