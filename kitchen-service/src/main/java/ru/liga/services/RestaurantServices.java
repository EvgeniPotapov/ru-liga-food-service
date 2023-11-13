package ru.liga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.dto.RestauranMenuItemsDto;
import ru.liga.dto.RestaurantDto;
import ru.liga.entities.RestauranMenuItemsEntity;
import ru.liga.entities.RestaurantEntity;
import ru.liga.mappers.RestaurantMapper;
import ru.liga.repository.RestaurantRepository;

import java.math.BigDecimal;
import java.util.UUID;

@Service
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

    /////////////////////получение id ресторана по его названию и изменение стоимости блюда/////////////////////////////
    public void updatePriceByNameItems (String nameRestaurant,
                                        String nameItems,
                                        BigDecimal price){
        UUID restauranId = restaurantRepository.getIdByName(nameRestaurant);
        restaurantRepository.updatePriceRestauranMenuItem(nameItems,price,restauranId);

    }
}
