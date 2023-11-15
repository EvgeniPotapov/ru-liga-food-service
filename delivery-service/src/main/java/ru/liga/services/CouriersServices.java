package ru.liga.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.dto.CouriersDto;
import ru.liga.dto.OrderDto;
import ru.liga.entities.CourierEntity;
import ru.liga.entities.OrderEntity;
import ru.liga.mappers.CourierMappers;
import ru.liga.repository.CouriersRepository;
import ru.liga.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
@Slf4j
public class CouriersServices {

    @Autowired
    CourierMappers courierMappers;
    @Autowired
    CouriersRepository couriersRepository;

    //////////////////////////////////////////Добавление курьера в базу данных//////////////////////////////////////////
   public void saveCouriers (CouriersDto couriersDto){

       CourierEntity courierEntity = courierMappers.dtoToEntity(couriersDto);
       couriersRepository.save(courierEntity);
   }

    //////////////////////////////////////////Удаление курьера из базы данных//////////////////////////////////////////
   public void  deleteCouriers(long id){

       couriersRepository.deleteCouriersById(id);
   }

    //////////////////////////////////////////Изменение статуса курьера//////////////////////////////////////////
    public void  updateCouriers(long id,String status){

        couriersRepository.updateCouriersById(id, status);
    }
}
