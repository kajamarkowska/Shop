package com.kaja.shop.domain.elastic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductElastic {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
}
