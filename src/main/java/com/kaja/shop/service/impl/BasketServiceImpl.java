package com.kaja.shop.service.impl;

import com.kaja.shop.domain.dto.ProductDto;
import com.kaja.shop.repository.BasketRepository;
import com.kaja.shop.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;

    @Override
    public void addToBasket(ProductDto productDto) {

    }
}
