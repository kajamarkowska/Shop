package com.kaja.shop.controller;

import com.kaja.shop.domain.dto.ProductDto;
import com.kaja.shop.mapper.ProductMapper;
import com.kaja.shop.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/basket")
public class BasketController {

    private final BasketService basketService;

    private final ProductMapper productMapper;

    @PostMapping
    public void addProductToBasket(@RequestBody ProductDto productDto) {
        System.out.println("abc");
        basketService.addToBasket(productDto);

    }

    @DeleteMapping("/{id}")
    public void deleteProductByIdInBasket(@PathVariable Long id) {
        basketService.deleteProductById(id);
    }

    @GetMapping
    public List<ProductDto> getUserBasket() {
        return productMapper.mapToListProductDto(basketService.basketForUser().getProducts());
    }

}
