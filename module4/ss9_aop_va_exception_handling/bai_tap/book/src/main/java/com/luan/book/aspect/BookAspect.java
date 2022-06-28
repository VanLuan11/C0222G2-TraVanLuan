package com.luan.book.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {
    @AfterReturning(pointcut = "execution(public * com.luan.book.controller.BookController.*(..))")
    public void log(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.out.println("Chức năng vừa thực hiện xong: "+ name);
    }
}
