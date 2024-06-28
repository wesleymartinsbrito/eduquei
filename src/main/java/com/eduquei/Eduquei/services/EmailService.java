package com.eduquei.Eduquei.services;

import com.eduquei.Eduquei.entities.Aluno;
import com.eduquei.Eduquei.entities.Email;
import com.eduquei.Eduquei.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    @Autowired
    private AlunoRepository alunoRepository;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(Email email){
        var message = new SimpleMailMessage();
        message.setFrom("noreply@gmail.com");
        message.setTo(email.to());
        message.setSubject(email.subject());
        message.setText(email.body());
        mailSender.send(message);
    }
}
