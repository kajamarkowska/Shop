package com.kaja.shop.mapper;

import com.kaja.shop.domain.dao.Product;
import com.kaja.shop.domain.dto.ProductDto;
import com.kaja.shop.domain.elastic.ProductElastic;

import java.util.List;

public interface ProductMapper {

    Product productDtoToProduct(ProductDto productDto);

    ProductDto productToProductDto(Product product);

    ProductDto productElasticToProduct(ProductElastic productElastic);

    List<ProductDto> mapToListProductDto(List<ProductElastic> productElastics);

}
