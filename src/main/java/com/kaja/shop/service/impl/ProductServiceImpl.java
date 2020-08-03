package com.kaja.shop.service.impl;

import com.kaja.shop.domain.dao.Product;
import com.kaja.shop.repository.ProductRepository;
import com.kaja.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    }

    @Override
    public Page<Product> page(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        Product product = findProductById(id);
        product.setDeleted(true);
        save(product);
    }
}
