package com.eduquei.Eduquei.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Turma turma;
    private Escola escola;

    public Aluno(){

    }

    public Aluno(Long id, String name, Integer age, String email, Turma turma, Escola escola) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.turma = turma;
        this.escola = escola;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id) && Objects.equals(name, aluno.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
