package com.eduquei.Eduquei.entities;

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
    private Long temaId;

    @ManyToOne (cascade= CascadeType.ALL)
    @JoinColumn(name = "escola_id")
    private Escola escola;

    public Aula(Long id, Long temaId, Escola escola) {
        this.id = id;
        this.temaId = temaId;
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

    public Long getTemaId() {
        return temaId;
    }

    public void setTemaId(Long temaId) {
        this.temaId = temaId;
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
