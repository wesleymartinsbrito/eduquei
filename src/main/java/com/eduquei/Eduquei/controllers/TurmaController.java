package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Turma;
import com.eduquei.Eduquei.services.AlunoService;
import com.eduquei.Eduquei.services.TurmaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/turmas")
public class TurmaController {
    @Autowired
    private TurmaService turmaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Turma> findById(Long id){
        return ResponseEntity.ok().body(turmaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Turma>> findAll(){
        return ResponseEntity.ok().body(turmaService.findAll());
    }
}
