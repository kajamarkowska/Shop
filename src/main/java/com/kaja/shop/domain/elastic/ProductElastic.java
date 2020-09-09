package com.kaja.shop.domain.elastic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductElastic {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
}
