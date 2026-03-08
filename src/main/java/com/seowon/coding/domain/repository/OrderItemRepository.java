package com.seowon.coding.domain.repository;

import com.seowon.coding.domain.model.Order;
import com.seowon.coding.domain.model.OrderItem;
import com.seowon.coding.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query("select i from OrderItem i where i.order =:order and i.product = :product and i.quantity = :qty and i.price =:price")
    OrderItem findByCheckoutOrder(@Param("order") Order order, @Param("product")Product product, @Param("qty")int quantity, BigDecimal price);
}
