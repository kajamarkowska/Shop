package com.kaja.shop.mailTypeGenerator.strategy;

import com.kaja.shop.mailTypeGenerator.MailType;
import org.springframework.stereotype.Component;

@Component
public class GeneratorPrivateMail implements StrategyMail {
    @Override
    public byte[] generateMailType() {
        return new byte[0];
    }


    @Override
    public MailType getType() {
        return MailType.PRIVATE;
    }
}
