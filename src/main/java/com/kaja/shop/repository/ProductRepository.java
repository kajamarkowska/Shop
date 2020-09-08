package com.kaja.shop.repository;

import com.kaja.shop.domain.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
