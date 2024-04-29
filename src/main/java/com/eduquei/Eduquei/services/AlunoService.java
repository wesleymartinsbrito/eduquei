package com.eduquei.Eduquei.services;

import com.eduquei.Eduquei.entities.Aluno;
import com.eduquei.Eduquei.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional(readOnly = true)
    public Aluno findById(Long id) {
        return alunoRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Aluno> findAll(){
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }
}
