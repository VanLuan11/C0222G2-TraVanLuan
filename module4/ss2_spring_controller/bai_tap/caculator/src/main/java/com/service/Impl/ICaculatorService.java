package com.service.Impl;

import org.springframework.stereotype.Service;

@Service
public class ICaculatorService implements com.service.ICaculatorService {
    @Override
    public Integer caculator(int num1, int num2, String operator) {
        Integer result = 0;
        switch (operator){
            case "add":
                result = num1 + num2;
                break;
            case "sud":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                result = num1/num2;
                break;
            default:
                try {
                    result = num1/num2;
                    result = 0;
                }catch (Exception e){
                    System.err.println("ádasd");
                }
                break;
        }
        return result;
    }
}
