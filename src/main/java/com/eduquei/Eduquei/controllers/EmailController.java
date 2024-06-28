package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Email;
import com.eduquei.Eduquei.services.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email", produces = {"application/json"})
@Tag(name = "Eduquei-Email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @Operation(summary = "Realiza o envio do e-mail", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Email enviado"),
            @ApiResponse(responseCode = "422", description = "Id incorreto"),
            @ApiResponse(responseCode = "400", description = "Parametros id inválido"),
            @ApiResponse(responseCode = "500", description = "Id incorreto"),
    })
    @PostMapping
    public void sendEmail(@RequestBody Email email){
        emailService.sendEmail(email);
    }
}
