package com.kaja.shop.service.impl;

import com.kaja.shop.domain.dao.Product;
import com.kaja.shop.domain.dao.User;
import com.kaja.shop.domain.dto.ProductDto;
import com.kaja.shop.domain.elastic.Basket;
import com.kaja.shop.domain.elastic.ProductElastic;
import com.kaja.shop.repository.BasketRepository;
import com.kaja.shop.service.BasketService;
import com.kaja.shop.service.ProductService;
import com.kaja.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;

    private final UserService userService;

    private final ProductService productService;

    @Override
    public void addToBasket(ProductDto productDto) {
        User currentUser = userService.getCurrentUser();
        Product product = productService.findProductById(productDto.getId());
        basketRepository.findByUserId(currentUser.getId()).map(basket -> {
            Optional<ProductElastic> optionalProductElastic = basket.getProducts().stream()
                    .filter(productElastic -> product.getId().equals(productElastic.getId()))
                    .findFirst();
            ProductElastic newProductElastic = optionalProductElastic.map(productElastic -> {
                if (product.getQuantity() >= productDto.getQuantity()) {
                    return createProductElastic(product, productDto.getQuantity());
                } else {
                    return createProductElastic(product, product.getQuantity());
                }

            }).orElseGet(() -> {
                if (product.getQuantity() >= productDto.getQuantity()) {
                    return createProductElastic(product, productDto.getQuantity());
                } else {
                    return createProductElastic(product, product.getQuantity());

                }

            });

            basket.getProducts().removeIf(productElastic -> product.getId().equals(productElastic.getId()));
            basket.getProducts().add(newProductElastic);
            return basketRepository.save(basket);
        }).orElseThrow(() -> new EntityNotFoundException("This: " + product + "was not found"));
    }

    @Override
    public Basket basketForUser() {
        return basketRepository.findByUserId(userService.getCurrentUser().getId()).orElseThrow(()-> new EntityNotFoundException("Basket does not exist"));
    }

    @Override
    public void deleteProductById(Long id) {
        Basket basket = basketForUser();
        basket.getProducts().removeIf(productElastic -> productElastic.getId().equals(id));
        basketRepository.save(basket);
    }

    private ProductElastic createProductElastic(Product product, Integer quantity) {
        return ProductElastic.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(quantity)
                .build();

    }


}

