package com.kaja.shop.mapper.impl

import com.kaja.shop.domain.dao.Product
import com.kaja.shop.domain.dto.ProductDto
import spock.lang.Specification

class ProductMapperImplSpec extends Specification {
    def "test product to product dto"() {
        given:
        def productMapperImpl = new ProductMapperImpl()
        def product = Product.builder()
                .id(1)
                .name("Game2")
                .description('dfgvdsfhbfcxgb')
                .price(12)
                .quantity(1)
                .version(1)
                .build()

        when:
        def result = productMapperImpl.productToProductDto(product);

        then:
        result.id == product.id
        result.name == product.name
        result.description == product.description
        result.price == product.price
        result.quantity == product.quantity
        result.version == product.version
    }

    def "test product dto to product"() {
        given:
        def productMapperImpl = new ProductMapperImpl()
        def productDto = ProductDto.builder()
                .id(1)
                .name("Sims3")
                .description("asdfghjkjgdfgh")
                .price(13)
                .quantity(1)
                .version(1)
                .build()

        when:
        def testResult = productMapperImpl.productDtoToProduct(productDto);

        then:
        testResult.id == productDto.id
        testResult.name == productDto.name
        testResult.description == productDto.description
        testResult.price == productDto.price
        testResult.quantity == productDto.quantity
        testResult.version == productDto.version

    }

}