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

    @Transactional(readOnly = false)
    public Escola update(Long id, Escola entity){
        Escola obj = escolaRepository.getReferenceById(id);
        updateMethod(obj, entity);
        return escolaRepository.save(obj);
    }

    private void updateMethod(Escola obj, Escola entity) {
        obj.setName(entity.getName());
        obj.setEstado(entity.getEstado());
        obj.setCidade(entity.getCidade());
        obj.setBairro(entity.getBairro());
        obj.setRua(entity.getRua());
        obj.setNumero(entity.getNumero());
    }

    @Transactional(readOnly = false)
    public Escola updateName(Long id, Escola entity){
        Escola obj = escolaRepository.getReferenceById(id);
        updateNameMethod(obj, entity);
        return escolaRepository.save(obj);
    }

    private void updateNameMethod(Escola obj, Escola entity) {
        obj.setName(entity.getName());
    }

    public Escola updateEndereco(Long id, Escola entity){
        Escola obj = escolaRepository.getReferenceById(id);
        updateEnderecoMethod(obj, entity);
        return escolaRepository.save(obj);
    }

    private void updateEnderecoMethod(Escola obj, Escola entity) {
        obj.setBairro(entity.getBairro());
        obj.setRua(entity.getRua());
        obj.setNumero(entity.getNumero());
    }
}
