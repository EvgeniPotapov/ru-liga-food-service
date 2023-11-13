package ru.liga.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ru.liga.orderDto.OrderDto;

import java.util.UUID;


@Component
@Aspect
@Slf4j
public class MyAspect {

    @Around("Pointcuts.allDetMethods()")
    public Object aroundGetAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        ////////////////////////логирование orderService/////////////////////////////////////

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        OrderDto  orderDto=null;
        if (methodSignature.getName().equals("getOrderById")) {

            UUID id=null;
            try {
                orderDto = (OrderDto) proceedingJoinPoint.proceed();
                Object []  arguments = proceedingJoinPoint.getArgs();
                for (Object arg : arguments){
                    if(arg instanceof UUID){
                        id= (UUID) arg;
                    }
                }

                log.info("Попытка получения заказа по Id равному {}",id);
                if (orderDto == null) {
                    log.info("заказ с id равным {} не найден",id);
                    throw new NotFoundException("not found");

                }
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        log.info("заказ найден");
        return orderDto;
    }


}
