package com.eduquei.Eduquei.controllers;

import com.eduquei.Eduquei.entities.Email;
import com.eduquei.Eduquei.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public void sendEmail(@RequestBody Email email){
        emailService.sendEmail(email);
    }
}
