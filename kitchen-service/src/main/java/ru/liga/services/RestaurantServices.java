package ru.liga.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.dto.RestauranMenuItemsDto;
import ru.liga.dto.RestaurantDto;
import ru.liga.entities.RestauranMenuItemsEntity;
import ru.liga.entities.RestaurantEntity;
import ru.liga.mappers.RestaurantMapper;
import ru.liga.repository.RestaurantRepository;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Slf4j
public class RestaurantServices {

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    RestaurantMapper restaurantMapper;

    //////////////////////////Сохранение рестороана + меню ресторана//////////////////////////////////////////////
    public void saveRestaurant (RestaurantDto restaurantDto){

       RestaurantEntity restaurantEntity = restaurantMapper.dtoToEntity(restaurantDto);
       restaurantRepository.save(restaurantEntity);
    }

    //////////////////////////Сохранение меню ресторана с привязкой к ресторану////////////////////////////////////////
    public void saveMenuRestaurant (String nameRestaurant,
                                    RestauranMenuItemsDto restauranMenuItemsDto){
       UUID restauranId = restaurantRepository.getIdByName(nameRestaurant);
       RestauranMenuItemsEntity restauranMenuItemsEntity =restaurantMapper.dtoToEntity(restauranMenuItemsDto);
       restauranMenuItemsEntity.setRestauranId(restauranId);
       restaurantRepository.save(restauranMenuItemsEntity);

    }

    /////////////////////////////////////////изменение стоимости блюда///////////////////////////////////////
    public void updatePriceByNameItems (String nameRestaurant,
                                        String nameItems,
                                        BigDecimal price)  {
        try {
        log.info("попытка изменения стоимости блюда");
        UUID restauranId = restaurantRepository.getIdByName(nameRestaurant);
        UUID menuId=restaurantRepository.getIdByMenuName(restauranId,nameItems);

        if (restauranId==null){
            log.info("Ресторана названием {} не существует",nameRestaurant);

                throw new NotFoundException("not found");
        }
        if (menuId==null){
            log.info("блюда с названием {} не существует",nameItems);
            throw new NotFoundException("not found");
        }
        restaurantRepository.updatePriceRestauranMenuItem(menuId,price);
        log.info("Стоимость на блюдо {} измененна",nameItems);

        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
