package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Escola;
import com.eduquei.Eduquei.services.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<Escola> insert(@RequestBody Escola entity){
        return ResponseEntity.ok().body(escolaService.insert(entity));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        escolaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Escola> update(@PathVariable Long id, @RequestBody Escola entity){
        return ResponseEntity.ok().body(escolaService.update(id, entity));
    }

    @PutMapping(value = "/{id}/name")
    public ResponseEntity<Escola> updateName(@PathVariable Long id, @RequestBody Escola entity){
        return ResponseEntity.ok().body(escolaService.updateName(id, entity));
    }

    @PutMapping(value = "/{id}/endereco")
    public ResponseEntity<Escola> updateEndereco(@PathVariable Long id, @RequestBody Escola entity){
        return ResponseEntity.ok().body(escolaService.updateEndereco(id, entity));
    }
}
