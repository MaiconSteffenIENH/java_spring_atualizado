package br.com.ienh.springacessobanco.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "incomes")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    private double value;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private IncomeCategory category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    public Income() {}

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

    @Override
    public String toString() {
        return "Income{" +
                "value=" + value +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", category_id=" + category +
                ", user_id=" + user +
                '}';
    }
}
