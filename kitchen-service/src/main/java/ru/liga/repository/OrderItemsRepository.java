package ru.liga.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.liga.entities.OrderItemsEntity;

import javax.transaction.Transactional;
import java.math.BigDecimal;

//Выполнение запросов к базе данных (заказ клиента)
public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity,Long> {

    OrderItemsEntity findOrderItemsById(long id);

    OrderItemsEntity findOrderItemsByPrice(BigDecimal price);

    OrderItemsEntity save (OrderItemsEntity orderItemsEntity);
    @Modifying
    @Transactional
    @Query("delete OrderItemsEntity res  where res.id = :id")
    void deleteOrderItemsById(@Param("id") long id);


}
