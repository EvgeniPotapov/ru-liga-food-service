package ru.liga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantDto {

    private String address;

    private String status;

    private String nameRestaurant;

    private List<RestauranMenuItemsDto> listMenuItems;
}
