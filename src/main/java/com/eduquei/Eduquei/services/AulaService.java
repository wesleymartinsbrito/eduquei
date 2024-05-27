package com.eduquei.Eduquei.services;

import com.eduquei.Eduquei.entities.Aula;
import com.eduquei.Eduquei.exceptions.AulaNotFoundException;
import com.eduquei.Eduquei.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AulaService {
    @Autowired
    private AulaRepository aulaRepository;
    @Transactional(readOnly = true)
    public Aula findById(Long id){
        return aulaRepository.findById(id).orElseThrow(AulaNotFoundException::new);
    }
    @Transactional(readOnly = true)
    public List<Aula> findAll(){
        return aulaRepository.findAll();
    }



    @Transactional(readOnly = false)
    public Aula insert(Aula aula){
        return aulaRepository.save(aula);
    }
}
