package com.eduquei.Eduquei.infra.security;

import com.eduquei.Eduquei.entities.Aluno;
import com.eduquei.Eduquei.entities.AuthenticationDTO;
import com.eduquei.Eduquei.entities.LoginResponseDTO;
import com.eduquei.Eduquei.entities.RegisterDTO;
import com.eduquei.Eduquei.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AlunoRepository alunoRepository;
    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Aluno) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody RegisterDTO data){
        if(alunoRepository.findByEmail(data.login()) != null){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Aluno aluno = new Aluno(data.login(), encryptedPassword, data.role());
        this.alunoRepository.save(aluno);
        return ResponseEntity.ok().build();
    }
}
