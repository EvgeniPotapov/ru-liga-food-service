package ru.liga.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.entities.CouriersEntity;


@Repository
public interface CouriersRepository extends JpaRepository<CouriersEntity, Long> {

    //Запросы на получение данных из базы данных
    CouriersEntity findCouriersById(long id);

    CouriersEntity findCouriersByPhone(String phone);

     CouriersEntity save(CouriersEntity couriersEntity);

    void deleteById(long id);



}

