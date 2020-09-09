package com.kaja.shop.repository;

import com.kaja.shop.domain.elastic.Basket;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BasketRepository extends ElasticsearchRepository<Basket, String> {
}
