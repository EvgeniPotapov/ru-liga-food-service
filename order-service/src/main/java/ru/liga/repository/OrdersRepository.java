package ru.liga.repository;

import org.springframework.data.repository.CrudRepository;
import ru.liga.entities.OrdersEntity;

public interface OrdersRepository extends CrudRepository<OrdersEntity,Long>{

    OrdersEntity findOrdersById(long id);

    OrdersEntity findOrdersByStatus(String status);
}
