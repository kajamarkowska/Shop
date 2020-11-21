package com.kaja.shop.controller;

import com.kaja.shop.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
    @GetMapping
    void getMessageFromMyService(){
     //   mailService.sendRegisterMail(user.getEmail());
    }
}
