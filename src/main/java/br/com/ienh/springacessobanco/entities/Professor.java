package br.com.ienh.springacessobanco.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "disciplina",
//            joinColumns = @JoinColumn(name = "professor_id"),
//            inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
//    private List<Disciplina> disciplinas;

    public Professor(String nome) {
        this.nome = nome;
    }

    public Professor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

}
