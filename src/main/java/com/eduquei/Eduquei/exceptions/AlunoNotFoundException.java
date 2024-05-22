package com.eduquei.Eduquei.exceptions;

public class AlunoNotFoundException extends RuntimeException{
    public AlunoNotFoundException(){
        super("Aluno(a) não encontrado!");
    }
    public AlunoNotFoundException(String message){
        super(message);
    }
}
