package com.example.shoponlineapi.dto;


import com.example.shoponlineapi.model.Bill;
import com.example.shoponlineapi.model.Customer;
import com.example.shoponlineapi.model.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
public class PaymentDto {
    private List<OrderService> productOrderList;
    private Customer customer;
    private Bill bill;
}
