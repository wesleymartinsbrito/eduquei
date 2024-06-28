package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Aluno;
import com.eduquei.Eduquei.entities.Profissional;
import com.eduquei.Eduquei.services.ProfissionalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profissionais")
public class ProfissionalController {
    @Autowired
    private ProfissionalService profissionalService;

    @Operation(summary = "Realiza a busca de profissionais pelo ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Profissional encontrado"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @GetMapping(value = "/{id}")
    public Profissional findById(@PathVariable Long id){
        return profissionalService.findById(id);
    }

    @GetMapping
    public List<Profissional> findAll(){
        List<Profissional> profissionais = profissionalService.findAll();
        return profissionais;
    }
    @PostMapping
    public ResponseEntity<Profissional> insert(@RequestBody Profissional profissional){
        profissional = profissionalService.insert(profissional);
        return ResponseEntity.ok().body(profissional);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Profissional> update(@PathVariable Long id, @RequestBody Profissional profissional){
        profissional = profissionalService.update(id, profissional);
        return ResponseEntity.ok().body(profissional);
    }

    @PutMapping(value = "/{id}/name")
    public ResponseEntity<Profissional> updateName(@PathVariable Long id, @RequestBody Profissional profissional){
        profissional = profissionalService.updateName(id, profissional);
        return ResponseEntity.ok().body(profissional);
    }

    @PutMapping(value = "/{id}/age")
    public ResponseEntity<Profissional> updateAge(@PathVariable Long id, @RequestBody Profissional profissional){
        profissional = profissionalService.updateAge(id, profissional);
        return ResponseEntity.ok().body(profissional);
    }

    @PutMapping(value = "/{id}/email")
    public ResponseEntity<Profissional> updateEmail(@PathVariable Long id, @RequestBody Profissional profissional){
        profissional = profissionalService.updateEmail(id, profissional);
        return ResponseEntity.ok().body(profissional);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable Long id){
        profissionalService.deleteId(id);
        return ResponseEntity.noContent().build();
    }
}
