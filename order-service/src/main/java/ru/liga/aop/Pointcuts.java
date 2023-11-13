package ru.liga.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* ru.liga.services.OrderServices.get*(..))")
    public void allDetMethods(){}
}
