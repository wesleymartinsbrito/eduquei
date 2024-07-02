package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Chamado;
import com.eduquei.Eduquei.entities.Email;
import com.eduquei.Eduquei.repositories.ChamadoRepository;
import com.eduquei.Eduquei.services.ChamadoService;
import com.eduquei.Eduquei.services.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chamados", produces = {"application/json"})
@Tag(name = "Eduquei-Chamados")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Autowired
    private EmailService emailService;

    @Operation(summary = "Encontra um chamado por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chamado encontrado")})
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Chamado>> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(chamadoService.findById(id));
    }

    @Operation(summary = "Retorna todos os chamados cadastrados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chamados encontrados")})
    @GetMapping
    public ResponseEntity<List<Chamado>> findAll(){
        return ResponseEntity.ok().body(chamadoService.findAll());
    }

    @Operation(summary = "Cria um chamado novo", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chamado criado")})
    @PostMapping
    public ResponseEntity<Chamado> insert(@RequestBody Chamado chamado){

            Email email = new Email(chamado.getAluno().getEmail(), "Seu chamado foi cadastrado!", "Seu chamado " + chamado.getId() + " foi cadastrado com sucesso!");
            emailService.sendEmail(email);
            return ResponseEntity.ok().body(chamadoService.insert(chamado));
    }

    @Operation(summary = "Responde um chamado que já foi criado", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chamado respondido")})
    @PutMapping(value = "/responder/{id}")
    public ResponseEntity<Chamado> responderChamado(@PathVariable Long id, @RequestBody String resposta){
        Chamado entity = chamadoRepository.getReferenceById(id);
        Email email = new Email(entity.getAluno().getEmail(), "Seu chamado " +entity.getId()+ " foi respondido!", "Boas notícias, seu chamado de numero " +entity.getId()+ " foi respondido, você já pode estar acessando!");
        return ResponseEntity.ok().body(chamadoService.responderChamado(id, resposta));
    }
}
