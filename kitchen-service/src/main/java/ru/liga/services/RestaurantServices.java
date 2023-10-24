package ru.liga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.dto.RestaurantDto;
import ru.liga.entities.RestaurantEntity;
import ru.liga.mappers.RestaurantMapper;
import ru.liga.repository.RestauranRepository;

@Service
public class RestaurantServices {
    @Autowired
    RestauranRepository restauranRepository;
    @Autowired
    RestaurantMapper restaurantMapper;

    public RestaurantDto getRestaurantId(long id){

        RestaurantEntity restaurantEntity = restauranRepository.findRestaurantById(id);
        RestaurantDto restaurantDto = restaurantMapper.entityToDto(restaurantEntity);

        return restaurantDto;
    }

    public RestaurantDto getRestaurantStatus(String status){

        RestaurantEntity restaurantEntity = restauranRepository.findRestaurantByStatus(status);
        RestaurantDto restaurantDto = restaurantMapper.entityToDto(restaurantEntity);

        return restaurantDto;
    }


}
