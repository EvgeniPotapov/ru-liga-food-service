package ru.liga.orderDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemDto {

    private UUID orderId;

    private long restaurantMenuItemsId;

    private BigDecimal price;

    private int quantity;
}
