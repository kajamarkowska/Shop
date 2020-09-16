package com.kaja.shop.mapper.impl;

import com.kaja.shop.domain.dao.Product;
import com.kaja.shop.domain.dto.ProductDto;
import com.kaja.shop.domain.elastic.ProductElastic;
import com.kaja.shop.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product productDtoToProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .version(productDto.getVersion())
                .build();
    }

    @Override
    public ProductDto productToProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .version(product.getVersion())
                .build();
    }

    @Override
    public ProductDto productElasticToProduct(ProductElastic productElastic) {
        return ProductDto.builder()
                .id(productElastic.getId())
                .name(productElastic.getName())
                .quantity(productElastic.getQuantity())
                .price(productElastic.getPrice())
                .build();

    }

    @Override
    public List<ProductDto> mapToListProductDto(List<ProductElastic> productElastics) {
        return productElastics.stream()
                .map(this::productElasticToProduct)
                .collect(Collectors.toList());
    }

}
