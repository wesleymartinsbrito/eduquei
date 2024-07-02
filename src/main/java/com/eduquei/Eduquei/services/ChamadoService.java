package com.eduquei.Eduquei.services;

import com.eduquei.Eduquei.entities.Chamado;
import com.eduquei.Eduquei.repositories.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {
    @Autowired
    private ChamadoRepository chamadoRepository;

    @Transactional(readOnly = true)
    public Optional<Chamado> findById(Long id){
        return chamadoRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Chamado> findAll(){
        return chamadoRepository.findAll();
    }

    @Transactional(readOnly = false)
    public Chamado insert(Chamado chamado) {
        return chamadoRepository.save(chamado);
    }

    @Transactional(readOnly = false)
    public Chamado responderChamado(Long id, String resposta){
        Chamado obj = chamadoRepository.getReferenceById(id);
        obj.setResposta(resposta);
        return chamadoRepository.save(obj);
    }
}
