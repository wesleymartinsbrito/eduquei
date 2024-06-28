package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Aluno;
import com.eduquei.Eduquei.entities.Email;
import com.eduquei.Eduquei.services.AlunoService;
import com.eduquei.Eduquei.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/{id}")
    public Aluno findById(@PathVariable Long id){
        return alunoService.findById(id);
    }

    @GetMapping
    public List<Aluno> findAll(){
        List<Aluno> alunos = alunoService.findAll();
        return alunos;
    }
    @PostMapping
    public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno){
        aluno = alunoService.insert(aluno);
        Email email = new Email(aluno.getEmail(), "Cadastro realizado!", "Seu cadastro foi realizado, seja bem vindo a EDUQUEI!");
        emailService.sendEmail(email);
        return ResponseEntity.ok().body(aluno);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno){
        aluno = alunoService.update(id, aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @PutMapping(value = "/{id}/name")
    public ResponseEntity<Aluno> updateName(@PathVariable Long id, @RequestBody Aluno aluno){
        aluno = alunoService.updateName(id, aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @PutMapping(value = "/{id}/age")
    public ResponseEntity<Aluno> updateAge(@PathVariable Long id, @RequestBody Aluno aluno){
        aluno = alunoService.updateAge(id, aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @PutMapping(value = "/{id}/email")
    public ResponseEntity<Aluno> updateEmail(@PathVariable Long id, @RequestBody Aluno aluno){
        aluno = alunoService.updateEmail(id, aluno);
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable Long id){
        alunoService.deleteId(id);
        return ResponseEntity.noContent().build();
    }
}
