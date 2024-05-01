package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Turma;
import com.eduquei.Eduquei.services.AlunoService;
import com.eduquei.Eduquei.services.TurmaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Turma> insert(Turma turma){
        turmaService.insert(turma);
        return ResponseEntity.ok().body(turma);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        turmaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
