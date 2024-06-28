package com.eduquei.Eduquei.services;

import com.eduquei.Eduquei.entities.Aula;
import com.eduquei.Eduquei.exceptions.AulaNotFoundException;
import com.eduquei.Eduquei.repositories.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class AulaService {
    @Autowired
    private AulaRepository aulaRepository;
    @Transactional(readOnly = true)
    public Aula findById(Long id){
        return aulaRepository.findById(id).orElseThrow(AulaNotFoundException::new);
    }
    @Transactional(readOnly = true)
    public List<Aula> findAll(){
        return aulaRepository.findAll();
    }



    @Transactional(readOnly = false)
    public Aula insert(Aula aula){
        return aulaRepository.save(aula);
    }

    @Value("${file.upload.directory}")
    private String raiz;

    @Value("{file.download.directory}")
    private String directoryAulas;

    public void salvarAula(MultipartFile aula) {
        this.salvar(this.directoryAulas, aula);
    }

    public void salvar (String directory, MultipartFile arquivo){
        Path directoryPath = Paths.get(this.raiz, directory);
        Path arquivoPath = directoryPath.resolve(arquivo.getOriginalFilename());

        try {
            Files.createDirectories(directoryPath);
            arquivo.transferTo(arquivoPath.toFile());
        } catch (IOException e) {
            throw new RuntimeException("Ocorreu um problema ao realizar o upload do arquivo!" +e);
        }
    }
}
