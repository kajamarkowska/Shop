package com.kaja.shop.batch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCSV {

    private String name;
    private Integer quantity;
    private String description;
    private Double price;
}
