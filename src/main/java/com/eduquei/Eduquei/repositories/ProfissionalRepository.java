package com.eduquei.Eduquei.repositories;

import com.eduquei.Eduquei.entities.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    UserDetails findByEmail(String email);
}
