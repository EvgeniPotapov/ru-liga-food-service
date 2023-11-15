package ru.liga.orderDto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
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

    private Long courierId;

    private Date timeStamp;

    private List<OrderItemDto> orders;
}
