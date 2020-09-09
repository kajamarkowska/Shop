package com.kaja.shop.service;

import com.kaja.shop.domain.dto.ProductDto;

public interface BasketService {

    void addToBasket(ProductDto productDto);
}
