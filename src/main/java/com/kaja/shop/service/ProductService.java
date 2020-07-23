package com.kaja.shop.service;

import com.kaja.shop.domain.dao.Product;

public interface ProductService {

    Product save(Product product);

    Product findProductById(Long id);
}
