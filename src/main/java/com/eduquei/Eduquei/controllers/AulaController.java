package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Aula;
import com.eduquei.Eduquei.services.AulaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/aulas", produces = {"application/json"})
@Tag(name = "Eduquei-Aulas")
public class AulaController {
    @Autowired
    private AulaService aulaService;

    @Operation(summary = "Realiza a busca de todas as aulas", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aula encontrada"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @GetMapping
    public ResponseEntity<List<Aula>> findAll(){
        return ResponseEntity.ok().body(aulaService.findAll());
    }

    @Operation(summary = "Realiza a busca de uma aula pelo ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aula encontrada"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Aula> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(aulaService.findById(id));
    }

    @Operation(summary = "Insere uma aula", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aula encontrada"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @PostMapping
    public ResponseEntity<Aula> insert(@RequestBody Aula aula){
        return ResponseEntity.ok().body(aulaService.insert(aula));
    }

    @Operation(summary = "Realiza o upload do arquivo da aula", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aula encontrada"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @PostMapping("/upload")
    public void upload(@RequestParam MultipartFile aula){
        aulaService.salvarAula(aula);
    }
}
