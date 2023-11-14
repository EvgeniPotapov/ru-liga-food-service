package ru.liga.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    @Pointcut("execution(* ru.liga.services.RestaurantServices.saveRestaurant(..))")
    public void saveRestaurant(){}

    @Pointcut("execution(* ru.liga.services.RestaurantServices.saveMenuRestaurant(..))")
    public void saveMenu(){}
}
