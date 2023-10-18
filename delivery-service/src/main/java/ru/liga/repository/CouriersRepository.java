package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.liga.entities.CouriersEntity;


@Repository
public interface CouriersRepository extends CrudRepository<CouriersEntity,Long> {



    CouriersEntity findCouriersById(long id);

    CouriersEntity findCouriersByPhone(String phone);
}
