package ru.liga.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.entities.CouriersEntity;
import ru.liga.entities.OrdersEntity;

import java.util.List;
import java.util.Set;


@Repository
public interface CouriersRepository extends JpaRepository<CouriersEntity,Long> {

    //Запросы на получение данных из базы данных
    CouriersEntity findCouriersById(long id);

    CouriersEntity findCouriersByPhone(String phone);


}

