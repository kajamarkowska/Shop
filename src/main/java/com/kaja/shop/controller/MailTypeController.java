package com.kaja.shop.controller;

import com.kaja.shop.flyweight.GenericFactory;
import com.kaja.shop.generator.GeneratorFactory;
import com.kaja.shop.mailtypegenerator.MailType;
import com.kaja.shop.mailtypegenerator.strategy.StrategyMail;
import lombok.RequiredArgsConstructor;
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
    public void sendMail(@RequestParam MailType mailType) {
        genericFactory.getByKey(mailType).generateMailType();
    }


}
