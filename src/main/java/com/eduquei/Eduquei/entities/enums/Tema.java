package com.eduquei.Eduquei.entities.enums;

public enum Tema {
    BIOLOGIA ("BIOLOGIA"),
    QUIMICA ("QUIMICA"),
    FISICA ("FISICA"),
    HISTORIA ("HISTORIA"),
    GEOGRAFIA ("GEOGRAFIA"),
    FILOSOFIA ("FILOSOFIA"),
    SOCIOLOGIA ("SOCIOLOGIA"),
    MATEMATICA ("MATEMATICA"),
    REDACAO ("REDACAO");

    private String tema;

    Tema (String tema){
        this.tema = tema;
    }
    public String getTema(){
        return tema;
    }
}
