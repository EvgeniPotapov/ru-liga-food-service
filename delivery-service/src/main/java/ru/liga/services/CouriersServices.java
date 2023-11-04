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


        CouriersEntity couriersEntity = couriersRepository.findCouriersById(id);
        CouriersDto couriersDto = courierMappers.entityToDto(couriersEntity);

        return couriersDto;
    }

    public CouriersDto getCouriersPhone(String phone){
        CouriersDto couriersDto;

        CouriersEntity couriersEntity = couriersRepository.findCouriersByPhone(phone);
        couriersDto = courierMappers.entityToDto(couriersEntity);

        return couriersDto;
    }
}
