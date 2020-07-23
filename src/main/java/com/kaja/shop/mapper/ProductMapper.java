package com.kaja.shop.mapper;

import com.kaja.shop.domain.dao.Product;
import com.kaja.shop.domain.dto.ProductDto;

public interface ProductMapper {

    Product productDtoToProduct(ProductDto productDto);

    ProductDto productToProductDto(Product product);
}
