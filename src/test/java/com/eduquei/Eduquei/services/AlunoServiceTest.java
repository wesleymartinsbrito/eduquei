package com.eduquei.Eduquei.services;

import com.eduquei.Eduquei.entities.Aluno;
import com.eduquei.Eduquei.entities.Escola;
import com.eduquei.Eduquei.exceptions.ShortPasswordException;
import com.eduquei.Eduquei.repositories.AlunoRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class AlunoServiceTest {

    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoRepository alunoRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        Escola escola1 = new Escola(1L, "Escola", "Rua", 23, "Centro", "Cidade", "Estado", 13231L, "escola@gmail.com");
        Aluno aluno = new Aluno(1L, "Roberto", 23, "roberto@gmail.com", "teste123", escola1);
        lenient().when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));
    }

    @Test
    @DisplayName("Deve retornar uma lista com apenas um usuário")
    @Tag("teste-get")
    public void retornarListaComUmAluno() {
        when(alunoRepository.findAll()).thenReturn(Collections.singletonList(new Aluno()));
        List<Aluno> alunos = alunoService.findAll();

        Assertions.assertEquals(1, alunos.size());
    }

    @Test
    @DisplayName("Deve retornar o usuário baseado no ID que foi passado (1)")
    @Tag("teste-get")
    public void retornarUsuarioCorrespondenteAoID(){
        Aluno result = alunoService.findById(1L);
        assertNotNull(result);
    }

    @Test
    @DisplayName("Lança exceção com senha inferior a 8 digitos")
    @Tag("teste-post")
    public void lancarExcecaoSenhaInferior8Digitos(){
        Escola escola1 = new Escola(1L, "Escola", "Rua", 23, "Centro", "Cidade", "Estado", 13231L, "escola@gmail.com");
        Aluno aluno = new Aluno(1L, "Claudia", 18, "claudia@gmail.com", "teste12", escola1);
        Assertions.assertThrows(ShortPasswordException.class, () -> alunoService.insert(aluno));

    }
}