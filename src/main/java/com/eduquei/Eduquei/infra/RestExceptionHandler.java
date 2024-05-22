package com.eduquei.Eduquei.infra;

import com.eduquei.Eduquei.exceptions.AlunoNotFoundException;
import com.eduquei.Eduquei.exceptions.SameEmailException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(AlunoNotFoundException.class)
    private ResponseEntity<String> alunoNotFoundHandler(AlunoNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno(a) não encontrado.");
    }

    @ExceptionHandler(SameEmailException.class)
    private ResponseEntity<String> sameEmailException(SameEmailException exception){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("E-mail já utilizado.");
    }
}
