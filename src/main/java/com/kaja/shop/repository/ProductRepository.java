package com.kaja.shop.repository;

import com.kaja.shop.domain.dao.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT distinct name FROM product where name like '%?1%' order by name limit 5",nativeQuery = true)
    List<String> autocomplete(String name);

}
