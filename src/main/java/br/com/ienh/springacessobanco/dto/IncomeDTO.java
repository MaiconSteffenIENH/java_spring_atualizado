package br.com.ienh.springacessobanco.dto;

import br.com.ienh.springacessobanco.entities.IncomeCategory;
import br.com.ienh.springacessobanco.entities.Users;

import java.time.LocalDate;

public class IncomeDTO {
    private int id;
    private double value;
    private String description;
    private LocalDate date;
    private IncomeCategory category;
    private Users user;

    public IncomeDTO(int id, double value, String description, LocalDate date, IncomeCategory category, Users user) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.date = date;
        this.category = category;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public IncomeCategory getCategory() {
        return category;
    }

    public void setCategory(IncomeCategory category) {
        this.category = category;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
