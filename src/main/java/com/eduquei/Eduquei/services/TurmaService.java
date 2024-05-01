package com.eduquei.Eduquei.services;

import com.eduquei.Eduquei.entities.Turma;
import com.eduquei.Eduquei.repositories.AlunoRepository;
import com.eduquei.Eduquei.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository turmaRepository;

    @Transactional(readOnly = true)
    public Turma findById(Long id){
        return turmaRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Turma> findAll(){
        List<Turma> turmas = turmaRepository.findAll();
        return turmas;
    }

    @Transactional(readOnly = true)
    public Turma insert(Turma turma){
        return turmaRepository.save(turma);
    }

    @Transactional(readOnly = false)
    public void delete(Long id){
        Turma turma = turmaRepository.getReferenceById(id);
        turmaRepository.delete(turma);
    }

    @Transactional(readOnly = false)
    public Turma update(Long id, Turma turma){
        Turma obj = turmaRepository.getReferenceById(id);
        updateMethod(turma, obj);
        return turmaRepository.save(obj);
    }

    private void updateMethod(Turma turma, Turma obj) {
        turma.setName(obj.getName());
    }
}
