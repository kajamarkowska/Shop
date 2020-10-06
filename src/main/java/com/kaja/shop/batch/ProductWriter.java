package com.kaja.shop.batch;

import com.kaja.shop.domain.dao.Product;
import com.kaja.shop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductWriter implements ItemWriter<Product> {

    private final ProductRepository productRepository;

    @Override
    public void write(List<? extends Product> list) throws Exception {
        productRepository.saveAll(list);
    }

}
