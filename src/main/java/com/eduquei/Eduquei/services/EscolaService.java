package com.eduquei.Eduquei.services;

import com.eduquei.Eduquei.entities.Escola;
import com.eduquei.Eduquei.repositories.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaService {
    @Autowired
    private EscolaRepository escolaRepository;

    public Escola findById(Long id){
        return escolaRepository.findById(id).get();
    }
    public List<Escola> findAll(){
        return escolaRepository.findAll();
    }
}
