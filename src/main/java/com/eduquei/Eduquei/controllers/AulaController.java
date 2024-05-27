package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Aula;
import com.eduquei.Eduquei.services.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/aulas")
public class AulaController {
    @Autowired
    private AulaService aulaService;



    @GetMapping
    public ResponseEntity<List<Aula>> findAll(){
        return ResponseEntity.ok().body(aulaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Aula> insert(@RequestBody Aula aula){
        return ResponseEntity.ok().body(aulaService.insert(aula));
    }
}
