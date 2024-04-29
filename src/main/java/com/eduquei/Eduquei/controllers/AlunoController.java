package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Aluno;
import com.eduquei.Eduquei.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping(value = "/{id}")
    public Aluno findById(@PathVariable Long id){
        return alunoService.findById(id);
    }

    @GetMapping
    public List<Aluno> findAll(){
        List<Aluno> alunos = alunoService.findAll();
        return alunos;
    }
}
