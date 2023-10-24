package ru.liga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.dto.RestauranMenuItemsDto;
import ru.liga.entities.RestauranMenuItemsEntity;
import ru.liga.mappers.RestaurantItemMapper;
import ru.liga.repository.RestauranMenuItemsRepository;

import java.math.BigDecimal;

@Service
public class RestaurantItemServices {

    @Autowired
    RestaurantItemMapper restaurantItemMapper;
    @Autowired
    RestauranMenuItemsRepository restauranMenuItemsRepository;

    //получение меню ресторана по id
    public RestauranMenuItemsDto getRestauranMenuId (long id){
        RestauranMenuItemsEntity restauranMenuItemsEntity = restauranMenuItemsRepository.findRestauranMenuItemsById(id);

        RestauranMenuItemsDto restauranMenuItemsDto = restaurantItemMapper.entityToDto(restauranMenuItemsEntity);
        return restauranMenuItemsDto;

    }

    //сохранение меню ресторана
    public void saveRestauranMenu (RestauranMenuItemsDto restauranMenuItemsDto){
        RestauranMenuItemsEntity restauranMenuItemsEntity = restaurantItemMapper.dtoToEntity(restauranMenuItemsDto);

        restauranMenuItemsRepository.save(restauranMenuItemsEntity);
    }


    //удаление меню ресторана
    public void deleteRestauranMenu (long id){

        restauranMenuItemsRepository.deleteById(id);
    }
    //изменение цены в меню
    public void updatePriceMenu (long id, BigDecimal price){

        restauranMenuItemsRepository.updatePriceMenu(id, price);
    }




}
