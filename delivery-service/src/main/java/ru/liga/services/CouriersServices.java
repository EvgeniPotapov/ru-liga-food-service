package ru.liga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.dto.CouriersDto;
import ru.liga.entities.CouriersEntity;
import ru.liga.mappers.CourierMappers;
import ru.liga.repository.CouriersRepository;

@Service
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

        CouriersEntity couriersEntity = couriersRepository.findCouriersByPhone(phone);
        CouriersDto couriersDto = courierMappers.entityToDto(couriersEntity);

        return couriersDto;
    }
}
