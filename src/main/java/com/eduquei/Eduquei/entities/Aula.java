package com.eduquei.Eduquei.entities;

import com.eduquei.Eduquei.entities.enums.Tema;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_aula")
public class Aula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Tema tema;

    @ManyToOne (cascade= CascadeType.ALL)
    @JoinColumn(name = "escola_id")
    private Escola escola;

    public Aula(Long id, Tema tema, Escola escola, String fileName) {
        this.id = id;
        this.tema = tema;
        this.escola = escola;
    }

    public Aula(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
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
        Aula aula = (Aula) o;
        return Objects.equals(id, aula.id) && Objects.equals(escola, aula.escola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, escola);
    }
}
