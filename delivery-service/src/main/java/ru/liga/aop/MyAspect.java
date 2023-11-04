package ru.liga.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import ru.liga.dto.CouriersDto;



@Component
@Aspect
@Slf4j
public class MyAspect {

    @Around("Pointcuts.allDetMethods()")
    public Object aroundGetAdvice(ProceedingJoinPoint proceedingJoinPoint) {

        CouriersDto couriersDto = null;

         //Обработка искличений и логирование couriersService

        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        if (methodSignature.getName().equals("getCouriersId")) {
            Long id=null;
            try {
                couriersDto = (CouriersDto) proceedingJoinPoint.proceed();
                Object []  arguments = proceedingJoinPoint.getArgs();
                for (Object arg : arguments){
                    if(arg instanceof Long){
                       id= (Long) arg;
                    }
                }

                log.info("Попытка получения курьера по Id равному {}",id);
                if (couriersDto == null) {
                    log.info("Курьек с id равным {} не найден",id);
                    throw new NotFoundException("not found");

                }


            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        if (methodSignature.getName().equals("getCouriersPhone")){
            String phone=null;

            try {
                couriersDto = (CouriersDto) proceedingJoinPoint.proceed();

                Object []  arguments = proceedingJoinPoint.getArgs();
                for (Object arg : arguments){
                    if(arg instanceof String){
                        phone= (String) arg;
                    }
                }
                log.info("Попытка получения курьера по номеру телефона {} ", phone);
                if (couriersDto == null) {
                    log.info("Курьек с номером телефона равным {} не найден",phone);
                    throw new NullPointerException();

                }
            }catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }

        log.info("Курьер найден");
        return couriersDto;
    }


}
