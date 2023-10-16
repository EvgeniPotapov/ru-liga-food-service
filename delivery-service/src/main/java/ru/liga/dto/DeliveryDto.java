package ru.liga.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryDto {

    private long orderId;

    private RestaurantAddressDto restaurant;

    private CustomerAddressDto customer;

    private String payment;
}
