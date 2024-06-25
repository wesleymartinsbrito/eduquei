package com.eduquei.Eduquei.services;

import com.eduquei.Eduquei.entities.Aluno;
import com.eduquei.Eduquei.entities.Profissional;
import com.eduquei.Eduquei.exceptions.AlunoNotFoundException;
import com.eduquei.Eduquei.exceptions.SameEmailException;
import com.eduquei.Eduquei.repositories.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfissionalService {
    @Autowired
    private ProfissionalRepository profissionalRepository;

    @Transactional(readOnly = true)
    public Profissional findById(Long id) {
        return profissionalRepository.findById(id).orElseThrow(AlunoNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public List<Profissional> findAll(){
        List<Profissional> profissionais = profissionalRepository.findAll();
        return profissionais;
    }

    @Transactional(readOnly = false)
    public Profissional insert(Profissional profissional){
        if (profissional.getEmail().isEmpty()){
            throw new SameEmailException();
        } return profissionalRepository.save(profissional);
    }

    @Transactional(readOnly = false)
    public void deleteId(Long id){
        profissionalRepository.deleteById(id);
    }

    @Transactional(readOnly = false)
    public Profissional update(Long id, Profissional profissional){
        Profissional obj = profissionalRepository.getReferenceById(id);
        updateAluno(obj, profissional);
        return profissional.save(obj);
    }

    private void updateProfissional(Profissional obj, Profissional profissional) {
        obj.setName(profissional.getName());
        obj.setAge(profissional.getAge());
        obj.setEmail(profissional.getEmail());
    }

    @Transactional(readOnly = false)
    public Profissional updateName(Long id, Profissional profissional){
        Profissional obj = profissional.getReferenceById(id);
        updateNameMethod(obj, profissional);
        return profissional.save(obj);
    }

    private void updateNameMethod(Profissional obj, Profissional profissional) {
        obj.setName(profissionalRepository.getName());
    }

    @Transactional(readOnly = false)
    public Profissional updateAge(Long id, Profissional profissional){
        Profissional obj = profissionalRepository.getReferenceById(id);
        updateAgeMethod(obj, profissional);
        return profissionalRepository.save(obj);
    }

    private void updateAgeMethod(Profissional obj, Profissional profissional) {
        obj.setAge(profissional.getAge());
    }

    @Transactional(readOnly = false)
    public Profissional updateEmail (Long id, Profissional profissional) {
        Profissional obj = profissionalRepository.getReferenceById(id);
        updateEmailMethod(obj, profissional);
        return profissionalRepository.save(obj);
    }

    private void updateEmailMethod(Profissional obj, Profissional profissional) {
        obj.setEmail(profissional.getEmail());
    }
}
