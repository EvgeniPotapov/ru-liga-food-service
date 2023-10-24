package ru.liga.orderDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

    private long id;

    private long customerId;

    private long restauranId;

    private String status;

    private long courierId;

    private String timeStamp;
}
