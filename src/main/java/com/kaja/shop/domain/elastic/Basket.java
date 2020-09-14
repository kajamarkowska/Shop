package com.kaja.shop.domain.elastic;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@Document(indexName = "basket")
public class Basket {
    @Id
    private String id;
    private Long userId;

    private List<ProductElastic> products;
}
