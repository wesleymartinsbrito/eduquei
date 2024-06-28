package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Aluno;
import com.eduquei.Eduquei.entities.Email;
import com.eduquei.Eduquei.services.AlunoService;
import com.eduquei.Eduquei.services.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alunos", produces = {"application/json"})
@Tag(name = "Eduquei-Aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private EmailService emailService;

    @Operation(summary = "Realiza a busca de alunos por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @GetMapping(value = "/{id}")
    public Aluno findById(@PathVariable Long id){
        return alunoService.findById(id);
    }

    @Operation(summary = "Realiza a busca de todos os alunos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Alunos encontrados"),
            @ApiResponse(responseCode = "422", description = "Alunos não encontrados"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Alunos não encontrados"),
    })
    @GetMapping
    public List<Aluno> findAll(){
        List<Aluno> alunos = alunoService.findAll();
        return alunos;
    }
    @Operation(summary = "Insere um aluno", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno inserido"),
            @ApiResponse(responseCode = "422", description = "Parâmetro incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametro aluno inválido"),
            @ApiResponse(responseCode = "500", description = "Erro ao inserir aluno"),
    })
    @PostMapping
    public ResponseEntity<Aluno> insert(@RequestBody Aluno aluno){
        aluno = alunoService.insert(aluno);
        Email email = new Email(aluno.getEmail(), "Cadastro realizado!", "Seu cadastro foi realizado, seja bem vindo a EDUQUEI!");
        emailService.sendEmail(email);
        return ResponseEntity.ok().body(aluno);
    }
    @Operation(summary = "Realiza a atualização de alunos por ID", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Atualização realizada"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody Aluno aluno){
        aluno = alunoService.update(id, aluno);
        return ResponseEntity.ok().body(aluno);
    }
    @Operation(summary = "Atualiza o nome do aluno", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @PutMapping(value = "/{id}/name")
    public ResponseEntity<Aluno> updateName(@PathVariable Long id, @RequestBody Aluno aluno){
        aluno = alunoService.updateName(id, aluno);
        return ResponseEntity.ok().body(aluno);
    }
    @Operation(summary = "Atualiza a idade do aluno", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @PutMapping(value = "/{id}/age")
    public ResponseEntity<Aluno> updateAge(@PathVariable Long id, @RequestBody Aluno aluno){
        aluno = alunoService.updateAge(id, aluno);
        return ResponseEntity.ok().body(aluno);
    }
    @Operation(summary = "Atualiza o e-mail do aluno", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @PutMapping(value = "/{id}/email")
    public ResponseEntity<Aluno> updateEmail(@PathVariable Long id, @RequestBody Aluno aluno){
        aluno = alunoService.updateEmail(id, aluno);
        return ResponseEntity.ok().body(aluno);
    }
    @Operation(summary = "DELETA O ALUNO", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteId(@PathVariable Long id){
        alunoService.deleteId(id);
        return ResponseEntity.noContent().build();
    }
}
