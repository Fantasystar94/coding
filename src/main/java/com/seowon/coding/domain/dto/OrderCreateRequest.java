package com.seowon.coding.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/*
*      * Request body 예시:
 * {
 *   "customerName": "John Doe",
 *   "customerEmail": "john@example.com",
 *   "products": [
 *     {"productId": 1, "quantity": 2},
 *     {"productId": 3, "quantity": 1}
 *   ]
 * }
* */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequest {
    private String customerName;
    private String customerEmail;
    private List<Products> products;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Products {
        private Long productId;
        private Integer quantity;
    }
}
