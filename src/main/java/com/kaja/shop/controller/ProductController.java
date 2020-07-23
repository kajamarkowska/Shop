package com.kaja.shop.controller;
import com.kaja.shop.domain.dto.ProductDto;
import com.kaja.shop.mapper.ProductMapper;
import com.kaja.shop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    private final ProductMapper productMapper;

    @GetMapping("/{id}")
    public ProductDto searchProductById(@PathVariable Long id) {
        return productMapper.productToProductDto(productService.findProductById(id));
    }

    @PostMapping
    public ProductDto saveProduct(@RequestBody ProductDto productDto) {
        return productMapper.productToProductDto(productService.save(productMapper.productDtoToProduct(productDto)));

    }


}
