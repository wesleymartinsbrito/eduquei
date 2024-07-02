package com.eduquei.Eduquei.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_escola")
public class Escola implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "escola_id")
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private Integer numero;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private Long cnpj;

    @OneToMany(mappedBy = "escola")
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "escola")
    private List<Chamado> chamados;

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(Chamado chamados) {
        this.chamados = (List<Chamado>) chamados;
    }

    public Aluno getAlunos() {
        return (Aluno) alunos;
    }

    public void setAlunos(Aluno alunos) {
        this.alunos = (List<Aluno>) alunos;
    }

    public Escola (){

    }

    public Escola(Long id, String name, String rua, Integer numero, String bairro, String cidade, String estado, Long cnpj) {
        this.id = id;
        this.name = name;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cnpj = cnpj;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Escola escola = (Escola) o;
        return Objects.equals(id, escola.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }
}
