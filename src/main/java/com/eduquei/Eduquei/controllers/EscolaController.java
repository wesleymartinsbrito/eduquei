package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Escola;
import com.eduquei.Eduquei.services.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/escolas")
public class EscolaController {
    @Autowired
    private EscolaService escolaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Escola> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(escolaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Escola>> findAll(){
        return ResponseEntity.ok().body(escolaService.findAll());
    }

}
