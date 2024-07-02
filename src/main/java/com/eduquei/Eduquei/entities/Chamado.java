package com.eduquei.Eduquei.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_chamado")
public class Chamado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pergunta;
    private String resposta;
    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "escola_id", nullable = false)
    private Escola escola;

    public Chamado(){

    }
    public Chamado (String pergunta, Aluno aluno, Escola escola) {
        this.pergunta = pergunta;
        this.aluno = aluno;
        this.escola = escola;
    }

    public Chamado (String resposta){
        this.resposta = resposta;
    }

    public Chamado(String pergunta, String resposta, Aluno aluno, Escola escola) {
        this.pergunta = pergunta;
        this.resposta = resposta;
        this.aluno = aluno;
        this.escola = escola;
    }

    public Long getId() {
        return id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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
        Chamado chamado = (Chamado) o;
        return Objects.equals(id, chamado.id) && Objects.equals(escola, chamado.escola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, escola);
    }
}
