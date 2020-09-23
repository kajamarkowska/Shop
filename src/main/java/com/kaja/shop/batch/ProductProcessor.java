package com.kaja.shop.batch;

import com.kaja.shop.batch.domain.ProductCSV;
import com.kaja.shop.domain.dao.Product;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ProductProcessor implements ItemProcessor<ProductCSV, Product> {
    @Override
    public Product process(ProductCSV productCSV) throws Exception {
        return Product.builder()
                .name(productCSV.getName())
                .price(productCSV.getPrice())
                .description(productCSV.getDescription())
                .quantity(productCSV.getQuantity())
                .build();
    }
}
