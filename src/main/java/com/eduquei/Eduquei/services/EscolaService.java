package com.eduquei.Eduquei.services;

import com.eduquei.Eduquei.entities.Escola;
import com.eduquei.Eduquei.repositories.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EscolaService {
    @Autowired
    private EscolaRepository escolaRepository;

    @Transactional(readOnly = true)
    public Escola findById(Long id){
        return escolaRepository.findById(id).get();
    }
    @Transactional(readOnly = true)
    public List<Escola> findAll(){
        return escolaRepository.findAll();
    }

    @Transactional(readOnly = false)
    public Escola insert(Escola entity){
        return escolaRepository.save(entity);
    }

    @Transactional(readOnly = false)
    public void delete(Long id){
        Escola entity = escolaRepository.getReferenceById(id);
        escolaRepository.delete(entity);
    }

}
