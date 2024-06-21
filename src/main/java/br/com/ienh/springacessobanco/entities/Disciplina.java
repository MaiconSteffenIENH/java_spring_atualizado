//package br.com.ienh.springacessobanco.entities;
//
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "disciplina")
//public class Disciplina {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    @Column(name = "semestre")
//    private String semestre;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "aluno_turma",
//            joinColumns = @JoinColumn(name = "turma_id"),
//            inverseJoinColumns = @JoinColumn(name = "aluno_id"))
//    private List<Aluno> alunos;
//
//    public Disciplina(String semestre) {
//        this.semestre = semestre;
//    }
//
//    public Disciplina() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public List<Aluno> getAlunos() {
//        return alunos;
//    }
//
//    public void setAlunos(ArrayList<Aluno> alunos) {
//        this.alunos = alunos;
//    }
//
//    public List<Professor> getProfessores() {
//        return professores;
//    }
//
//    public void setProfessores(ArrayList<Professor> professores) {
//        this.professores = professores;
//    }
//
//    @Override
//    public String toString() {
//        return "Turma{" +
//                "id=" + id +
//                ", semestre='" + semestre + '\'' +
//                '}';
//    }
//
//}
