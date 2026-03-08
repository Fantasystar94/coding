package com.seowon.coding.domain.repository;

import com.seowon.coding.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    List<Order> findByCustomerEmail(String email);
    
    List<Order> findByStatus(Order.OrderStatus status);
    
    List<Order> findByOrderDateBetween(LocalDateTime start, LocalDateTime end);

    @Query("select o from Order o where o.customerName =:customerName and o.customerEmail =:customerEmail and o.status =:orderStatus and o.orderDate =:now and o.totalAmount =:totalAmount")
    Order findBycheckoutOrder(@Param("customerName") String customerName,
                                                       @Param("customerEmail") String customerEmail,
                                                       @Param("orderStatus") Order.OrderStatus orderStatus,
                                                       @Param("now") LocalDateTime localDateTime,
                                                       @Param("totalAmount") BigDecimal bigDecimal
    );
}