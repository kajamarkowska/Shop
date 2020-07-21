package com.kaja.shop.service.impl;

import com.kaja.shop.domain.Product;
import com.kaja.shop.repository.ProductRepository;
import com.kaja.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        //nie moge tutaj wyzej znalesc findproductby id
    }
}
