package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.liga.entities.CourierEntity;

import javax.transaction.Transactional;


@Repository
public interface CouriersRepository extends JpaRepository<CourierEntity, Long> {

    CourierEntity save(CourierEntity courierEntity);


    @Modifying
    @Transactional
    @Query("delete CourierEntity cour  where cour.id = :id")
    void deleteCouriersById(@Param("id") long id);

    @Modifying
    @Transactional
    @Query("update CourierEntity cour set cour.status = :status where cour.id = :id")
    void updateCouriersById(@Param("id") long id,@Param("status") String status);





}
