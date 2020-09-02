package com.kaja.shop.controller;

import com.kaja.shop.flyweight.GenericFactory;
import com.kaja.shop.generator.GeneratorFactory;
import com.kaja.shop.mailTypeGenerator.MailType;
import com.kaja.shop.mailTypeGenerator.strategy.StrategyMail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mails")
@RequiredArgsConstructor
public class MailTypeController {

    private final GeneratorFactory generatorFactory;

    private final GenericFactory<MailType, StrategyMail> genericFactory;

    @GetMapping
    void sendMail(@RequestParam MailType mailType) {
        genericFactory.getByKey(mailType).generateMailType();
    }


}
