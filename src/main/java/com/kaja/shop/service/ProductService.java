package com.kaja.shop.service;

import com.kaja.shop.domain.dao.Product;
import com.kaja.shop.domain.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Product save(Product product);

    Product findProductById(Long id);

    Page<Product> page(Pageable pageable);

    void delete(Long id);
}
