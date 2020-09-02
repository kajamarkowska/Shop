package com.kaja.shop.mailTypeGenerator.strategy;

import com.kaja.shop.flyweight.GenericStrategy;
import com.kaja.shop.mailTypeGenerator.MailType;

public interface StrategyMail extends GenericStrategy<MailType> {

    byte[] generateMailType();
}
