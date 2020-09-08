package com.kaja.shop.mailtypegenerator.strategy;

import com.kaja.shop.flyweight.GenericStrategy;
import com.kaja.shop.mailtypegenerator.MailType;

public interface StrategyMail extends GenericStrategy<MailType> {

    byte[] generateMailType();
}
