package ru.liga.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformationToCouriersDto {

    private long orderId;

    private RestaurantAddress restaurant;

    private CustomerAddress customer;

    private String payment;
}
