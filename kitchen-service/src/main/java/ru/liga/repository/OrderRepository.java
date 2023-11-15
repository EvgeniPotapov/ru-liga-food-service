package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.liga.entities.OrderEntity;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,UUID> {

    //Изменение статуса заказа
    @Modifying
    @Transactional
    @Query("update OrderEntity ord set ord.status = :status where ord.id = :id")
    void updateStatusOrder (@Param("id") UUID id, @Param("status") String status);

}
