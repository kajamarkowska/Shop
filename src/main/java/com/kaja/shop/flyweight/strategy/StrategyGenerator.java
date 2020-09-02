package com.kaja.shop.flyweight.strategy;

import com.kaja.shop.flyweight.GenericStrategy;
import com.kaja.shop.generator.domain.FileType;

public interface StrategyGenerator extends GenericStrategy <FileType> {

    byte[] generateFile();

}
