package ru.liga.orderDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentToOrderDto {

    private  long id;
    private String secret_payment_url;
    private String estimated_time_of_arrival;
}
