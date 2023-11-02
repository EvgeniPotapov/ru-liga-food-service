package ru.liga.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.dto.CouriersDto;
import ru.liga.entities.CouriersEntity;
import ru.liga.mappers.CourierMappers;
import ru.liga.repository.CouriersRepository;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class CouriersServices {
    @Autowired
    CouriersRepository couriersRepository;
    @Autowired
    CourierMappers courierMappers;

    public CouriersDto getCouriersId(long id){

//        try {
//            log.info("Попятка получения курьера по Id равному {} ",id);
        CouriersEntity couriersEntity = couriersRepository.findCouriersById(id);
        CouriersDto couriersDto = courierMappers.entityToDto(couriersEntity);
//        if (couriersEntity==null){
//            throw new NoSuchElementException();
//        }

//        }catch (NoSuchElementException e){
//            log.info("Курьек с Id равным {} не найден",id);
//            log.error(e.getMessage(),e);
//            return new CouriersDto(0,null,null,null);
//        }
//
//        log.info("Курьек с Id равным {} получен",id);
        return couriersDto;
    }

    public CouriersDto getCouriersPhone(String phone){
        CouriersDto couriersDto;
//        try{
//        log.info("Попятка получения курьера по номеру телефона равному {} ",phone);
        CouriersEntity couriersEntity = couriersRepository.findCouriersByPhone(phone);
        couriersDto = courierMappers.entityToDto(couriersEntity);
//            if (couriersEntity==null){
//                throw new NoSuchElementException();
//            }
//        }catch (NoSuchElementException e){
//            log.info("Курьек с номером телефона равным {} не найден",phone);
//            log.error(e.getMessage(),e);
//            return new CouriersDto(0,null,null,null);
//        }
//        log.info("Курьер с номе6ром телефона {} получен",phone);
        return couriersDto;
    }
}
