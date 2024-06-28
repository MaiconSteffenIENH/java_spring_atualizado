package br.com.ienh.springacessobanco.dto;

import br.com.ienh.springacessobanco.entities.ExpenseCategory;
import br.com.ienh.springacessobanco.entities.Users;

import java.time.LocalDate;

public class ExpenseDTO {
    private int id;
    private double value;
    private String description;
    private LocalDate date;
    private ExpenseCategory category;
    private Users user;

    public ExpenseDTO(int id, double value, String description, LocalDate date, ExpenseCategory category, Users user) {
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

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
