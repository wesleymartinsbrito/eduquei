package com.eduquei.Eduquei.exceptions;

public class ShortPasswordException extends RuntimeException{
    public ShortPasswordException(){
        super("Senha inferior a 8 digitos");
    }
    public ShortPasswordException(String message) {
        super(message);
    }
}
