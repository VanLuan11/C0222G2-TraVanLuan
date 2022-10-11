package com.example.shoponlineapi.service;



import com.example.shoponlineapi.dto.ErrorDTO;
import com.example.shoponlineapi.dto.PaymentDto;
import com.example.shoponlineapi.model.Customer;
import com.example.shoponlineapi.model.OrderService;

import java.util.List;

public interface IOrderService {
    ErrorDTO saveOrder(OrderService productOrder);

    List<OrderService> getProductInCardByCustomer(Customer customer);

    Boolean minusQuantity(OrderService orderService);

    Boolean plusQuantity(OrderService orderService);

    Boolean findProductOrder(OrderService orderService);

    PaymentDto goPayment(Customer customer);

    List<OrderService> getHistoryCustomerOrderProduct(Customer customer);

}
