package com.eduquei.Eduquei.exceptions;

import org.springframework.http.ResponseEntity;

public class AulaNotFoundException extends RuntimeException{
    public AulaNotFoundException(){
        super("Aula não encontrada!");
    }
    public AulaNotFoundException(String message){
        super(message);
    }
}
