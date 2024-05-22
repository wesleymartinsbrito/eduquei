package com.eduquei.Eduquei.exceptions;

public class SameEmailException extends RuntimeException{
    public SameEmailException(){
        super("Email já utilizado!");
    }
    public SameEmailException(String message){
        super(message);
    }
}
