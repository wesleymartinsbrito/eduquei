package com.eduquei.Eduquei.repositories;

import com.eduquei.Eduquei.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
