package com.example.shoponlineapi.service.impl;


import com.example.shoponlineapi.dto.ErrorDTO;
import com.example.shoponlineapi.dto.PaymentDto;
import com.example.shoponlineapi.model.Bill;
import com.example.shoponlineapi.model.Customer;
import com.example.shoponlineapi.model.OrderService;
import com.example.shoponlineapi.model.Product;
import com.example.shoponlineapi.repository.IBillRepository;
import com.example.shoponlineapi.repository.IOrderServiceRepository;
import com.example.shoponlineapi.repository.IProductRepository;
import com.example.shoponlineapi.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    private IOrderServiceRepository productOrderRepository;

    @Autowired
    private IBillRepository billRepository;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public ErrorDTO saveOrder(OrderService productOrder) {
        ErrorDTO errorDto = new ErrorDTO();
        productOrder.setIsDeleted(false);
        OrderService po = this.productOrderRepository.findProductOrderListByCustomerAndProduct(productOrder);
        if (po == null) {
            if (productOrder.getQuantity() > productOrder.getProduct().getQuantity()) {
                errorDto.setMessage("quantity");
                errorDto.setOrderService(po);
                return errorDto;
            } else {
                this.productOrderRepository.save(productOrder);
            }
        } else {
            if ((po.getQuantity() + productOrder.getQuantity()) > productOrder.getProduct().getQuantity()) {
                errorDto.setMessage("quantity");
                errorDto.setOrderService(po);
                return errorDto;
            } else {
                po.setQuantity(productOrder.getQuantity() + po.getQuantity());
                this.productOrderRepository.save(po);
            }
        }
        return errorDto;
    }

    @Override
    public List<OrderService> getProductInCardByCustomer(Customer customer) {
        return this.productOrderRepository.getProductInCardByCustomer(customer);
    }

    @Override
    public Boolean minusQuantity(OrderService productOrder) {
        if (productOrder.getQuantity() > 1) {
            productOrder.setQuantity(productOrder.getQuantity() - 1);
            this.productOrderRepository.save(productOrder);
            return true;
        }
        return false;
    }

    @Override
    public Boolean plusQuantity(OrderService productOrder) {
        if (productOrder.getQuantity() < productOrder.getProduct().getQuantity()) {
            productOrder.setQuantity(productOrder.getQuantity() + 1);
            this.productOrderRepository.save(productOrder);
            return true;
        }
        return false;
    }

    @Override
    public Boolean findProductOrder(OrderService productOrder) {
        OrderService po = this.productOrderRepository.findById(productOrder.getId()).orElse(null);
        if (po != null) {
            this.productOrderRepository.delete(productOrder);
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public PaymentDto goPayment(Customer customer) {
        List<OrderService> productOrderList = this.productOrderRepository.getProductInCardByCustomer(customer);
        List<Bill> billList = this.billRepository.findAll();
        int randomCode = this.getRandomNumber(billList);
        Bill bill = new Bill();
        bill.setCode(String.valueOf(randomCode));
        bill.setProductOrderList(productOrderList);
        bill.setIsDeleted(false);
        bill.setCreationDate(new Date(System.currentTimeMillis()));
        this.billRepository.save(bill);
        Bill billReturn = this.billRepository.getBillByCode(randomCode);
        this.productOrderRepository.setBill(customer.getId(), billReturn.getId());
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setBill(billReturn);
        paymentDto.setProductOrderList(productOrderList);
        paymentDto.setCustomer(customer);
        for (OrderService productOrder: productOrderList) {
            this.productRepository.updateQuantity(productOrder.getQuantity(), productOrder.getProduct().getId());
            Product product = this.productRepository.getById(productOrder.getProduct().getId());
            if (product.getQuantity() <= 1) {
                this.productRepository.updateIsDeleted(product.getId());
            }
        }
        return paymentDto;
    }

    @Override
    public List<OrderService> getHistoryCustomerOrderProduct(Customer customer) {
        return productOrderRepository.getHistoryCustomerOrderProduct(customer);
    }


    private int getRandomNumber(List<Bill> billList) {
        int randomNumber = 10000;
        while (checkExists(billList, randomNumber)) {
            randomNumber = (int) ( (Math.random() * 89999) + 10001);
        }
        return randomNumber;
    }

    private boolean checkExists(List<Bill> billList, int randomNumber) {
        for (Bill bill : billList) {
            if (Integer.parseInt(bill.getCode()) == randomNumber) {
                return true;
            }
        }
        return false;
    }

}
