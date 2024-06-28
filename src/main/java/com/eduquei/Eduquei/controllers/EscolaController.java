package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Escola;
import com.eduquei.Eduquei.services.EscolaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/escolas", produces = {"application/json"})
@Tag(name = "Eduquei-Escola")
public class EscolaController {
    @Autowired
    private EscolaService escolaService;

    @Operation(summary = "Realiza a busca por escola pelo ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Escola encontrada"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @GetMapping(value = "/{id}")
    public ResponseEntity<Escola> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(escolaService.findById(id));
    }

    @Operation(summary = "Realiza a busca por todas as escolas", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Escola encontrada"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @GetMapping
    public ResponseEntity<List<Escola>> findAll(){
        return ResponseEntity.ok().body(escolaService.findAll());
    }

    @Operation(summary = "Insere uma escola", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Escola cadastrada"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @PostMapping
    public ResponseEntity<Escola> insert(@RequestBody Escola entity){
        return ResponseEntity.ok().body(escolaService.insert(entity));
    }

    @Operation(summary = "Deleta uma escola", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Escola deletada"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        escolaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Realiza atualização no cadastro da escola", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aula não encontrada"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<Escola> update(@PathVariable Long id, @RequestBody Escola entity){
        return ResponseEntity.ok().body(escolaService.update(id, entity));
    }

    @Operation(summary = "Realiza atualização no nome da escola", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aula não encontrada"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @PutMapping(value = "/{id}/name")
    public ResponseEntity<Escola> updateName(@PathVariable Long id, @RequestBody Escola entity){
        return ResponseEntity.ok().body(escolaService.updateName(id, entity));
    }

    @Operation(summary = "Realiza atualização no endereço da escola", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aula não encontrada"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @PutMapping(value = "/{id}/endereco")
    public ResponseEntity<Escola> updateEndereco(@PathVariable Long id, @RequestBody Escola entity){
        return ResponseEntity.ok().body(escolaService.updateEndereco(id, entity));
    }
}
