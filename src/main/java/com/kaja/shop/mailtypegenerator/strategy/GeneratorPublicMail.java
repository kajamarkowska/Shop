package com.kaja.shop.mailtypegenerator.strategy;

import com.kaja.shop.mailtypegenerator.MailType;
import org.springframework.stereotype.Component;

@Component
public class GeneratorPublicMail implements StrategyMail {
    @Override
    public byte[] generateMailType() {
        return new byte[0];
    }

    @Override
    public MailType getType() {
        return MailType.PUBLIC;
    }
}
