package com.example.shoponlineapi.repository;


import com.example.shoponlineapi.model.Customer;
import com.example.shoponlineapi.model.OrderService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IOrderServiceRepository extends JpaRepository<OrderService, Integer> {
    @Query(value = " select po.* from order_service po " +
            " join customer c on c.id = po.customer_id " +
            " join product p on p.id = po.product_id " +
            " where po.customer_id = :#{#productOrder.customer.id} and po.product_id = :#{#productOrder.product.id} and po.bill_id is null ", nativeQuery = true)
    OrderService findProductOrderListByCustomerAndProduct(OrderService productOrder);

    @Query(value = " select po.* from order_service po " +
            " join customer c on c.id = po.customer_id " +
            " join product p on p.id = po.product_id " +
            " where po.customer_id = :#{#customer.id} and bill_id is null ", nativeQuery = true)
    List<OrderService> getProductInCardByCustomer(Customer customer);

    @Modifying
    @Transactional
    @Query(value = " UPDATE `order_service` SET `bill_id` = :billId WHERE (`customer_id` = :customerId) and `bill_id` is null ", nativeQuery = true)
    void setBill(@Param("customerId") Integer customerId, @Param("billId") Integer billId);


    @Query(value = " select po.* from  order_service po " +
            " join customer c on po.customer_id = c.id " +
            " join product p on po.product_id = p.id " +
            " join bill b on po.bill_id = b.id " +
            " where po.customer_id = :#{#customer.id} and po.is_deleted = 0 ", nativeQuery = true)
    List<OrderService> getHistoryCustomerOrderProduct(Customer customer);
}
