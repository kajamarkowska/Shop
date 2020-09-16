package com.kaja.shop.service;

import com.kaja.shop.domain.dto.ProductDto;
import com.kaja.shop.domain.elastic.Basket;

public interface BasketService {

    void addToBasket(ProductDto productDto);

    Basket basketForUser();

    void deleteProductById(Long id);
}
