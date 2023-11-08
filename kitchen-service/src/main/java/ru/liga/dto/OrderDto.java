package ru.liga.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {


    private long customerId;

    private long restauranId;

    private String status;

    private long courierId;

    private Date timeStamp;

    private List<OrderItemDto> orders;
}
