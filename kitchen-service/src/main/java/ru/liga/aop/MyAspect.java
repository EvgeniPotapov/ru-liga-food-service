package ru.liga.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.liga.dto.RestauranMenuItemsDto;
import ru.liga.dto.RestaurantDto;

import java.math.BigDecimal;

@Component
@Aspect
@Slf4j
public class MyAspect {

    @Around("Pointcuts.saveRestaurant()")
    public void saveRestaurantAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        RestaurantDto restaurantDto=null;
            Object[] arguments = proceedingJoinPoint.getArgs();
            for (Object arg : arguments) {
                if (arg instanceof RestaurantDto) {
                    restaurantDto = (RestaurantDto) arg;
                    log.info("Попытка добавить ресторан с названием {}", restaurantDto.getNameRestaurant());
                }
            }
            try{
                proceedingJoinPoint.proceed();
                log.info("ресторан с названием {} добавлен",restaurantDto.getNameRestaurant());
            }catch (Throwable e){
                log.error(e.getMessage(),e);
                log.info("ресторан {} не добавлен",restaurantDto.getNameRestaurant());
            }
    }

    @Around("Pointcuts.saveMenu()")
    public void saveMenuAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        RestauranMenuItemsDto restauranMenuItemsDto =null;
        String nameRestaurant=null;
        Object[] arguments = proceedingJoinPoint.getArgs();
        for (Object arg : arguments) {
            if (arg instanceof String){
                nameRestaurant=(String) arg;
            }
            if (arg instanceof RestauranMenuItemsDto) {
                restauranMenuItemsDto = (RestauranMenuItemsDto) arg;
            }
        }
        log.info("Попытка добавить блюдо {} к ресторану {}", restauranMenuItemsDto.getNameItems(),nameRestaurant);
        try{
            proceedingJoinPoint.proceed();
            log.info("блюдо с названием {} добавлено",restauranMenuItemsDto.getNameItems());
        }catch (Throwable e){
            log.error(e.getMessage(),e);
            log.info("блюдо {} не добавлено",restauranMenuItemsDto.getNameItems());
        }
    }

}
