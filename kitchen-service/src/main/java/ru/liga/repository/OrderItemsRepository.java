package ru.liga.repository;


import org.springframework.data.repository.CrudRepository;
import ru.liga.entities.OrderItemsEntity;
import ru.liga.entities.RestauranMenuItemsEntity;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface OrderItemsRepository extends CrudRepository<OrderItemsEntity,Long> {

    OrderItemsEntity findOrderItemsById(long id);

    OrderItemsEntity findOrderItemsByPrice(BigDecimal price);

    OrderItemsEntity save (OrderItemsEntity orderItemsEntity);

}
