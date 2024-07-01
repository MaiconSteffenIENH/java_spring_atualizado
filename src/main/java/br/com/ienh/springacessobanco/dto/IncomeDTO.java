package br.com.ienh.springacessobanco.dto;

import java.time.LocalDate;

public class IncomeDTO {
    private Integer id;
    private double value;
    private String description;
    private LocalDate date;
    private Integer categoryId;
    private Integer userId;

    public IncomeDTO() {}

    public IncomeDTO(Integer id, double value, String description, LocalDate date, Integer categoryId, Integer userId) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.date = date;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
