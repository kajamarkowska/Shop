package com.kaja.shop.repository;

import com.kaja.shop.domain.elastic.Basket;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface BasketRepository extends ElasticsearchRepository<Basket, String> {



    Optional<Basket> findByUserId (Long userId);
}
