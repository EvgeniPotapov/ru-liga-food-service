package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.liga.entities.OrdersEntity;

public interface OrdersRepository extends JpaRepository<OrdersEntity,Long> {

    OrdersEntity findOrdersById(long id);

    OrdersEntity findOrdersByStatus(String status);
}
