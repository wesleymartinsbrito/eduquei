package com.eduquei.Eduquei.services;

import com.eduquei.Eduquei.entities.Aluno;
import com.eduquei.Eduquei.exceptions.AlunoNotFoundException;
import com.eduquei.Eduquei.exceptions.SameEmailException;
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
        return alunoRepository.findById(id).orElseThrow(AlunoNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<Aluno> findAll(){
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }

    @Transactional(readOnly = false)
    public Aluno insert(Aluno aluno){
        if (aluno.getEmail().isEmpty()){
            throw new SameEmailException();
        } return alunoRepository.save(aluno);
    }

    @Transactional(readOnly = false)
    public void deleteId(Long id){
        alunoRepository.deleteById(id);
    }

    @Transactional(readOnly = false)
    public Aluno update(Long id, Aluno aluno){
        Aluno obj = alunoRepository.getReferenceById(id);
        updateAluno(obj, aluno);
        return alunoRepository.save(obj);
    }

    private void updateAluno(Aluno obj, Aluno aluno) {
        obj.setName(aluno.getName());
        obj.setAge(aluno.getAge());
        obj.setEmail(aluno.getEmail());
    }

    @Transactional(readOnly = false)
    public Aluno updateName(Long id, Aluno aluno){
        Aluno obj = alunoRepository.getReferenceById(id);
        updateNameMethod(obj, aluno);
        return alunoRepository.save(obj);
    }

    private void updateNameMethod(Aluno obj, Aluno aluno) {
        obj.setName(aluno.getName());
    }

    @Transactional(readOnly = false)
    public Aluno updateAge(Long id, Aluno aluno){
        Aluno obj = alunoRepository.getReferenceById(id);
        updateAgeMethod(obj, aluno);
        return alunoRepository.save(obj);
    }

    private void updateAgeMethod(Aluno obj, Aluno aluno) {
        obj.setAge(aluno.getAge());
    }

    @Transactional(readOnly = false)
    public Aluno updateEmail (Long id, Aluno aluno) {
        Aluno obj = alunoRepository.getReferenceById(id);
        updateEmailMethod(obj, aluno);
        return alunoRepository.save(obj);
    }

    private void updateEmailMethod(Aluno obj, Aluno aluno) {
        obj.setEmail(aluno.getEmail());
    }

}
