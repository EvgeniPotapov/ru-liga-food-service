package ru.liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.entities.RestauranMenuItemsEntity;
import ru.liga.entities.RestaurantEntity;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.UUID;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity,Long> {

    //////////////////////////Сохранение рестороана//////////////////////////////////////////////

    RestaurantEntity save (RestaurantEntity restaurantEntity);

    //////////////////////////Сохранение меню рестороана////////////////////////////////////////

    RestauranMenuItemsEntity save (RestauranMenuItemsEntity restauranMenuItemsEntity);

    //////////////////////////Поиск id ресторана по его названию///////////////////////////////
    @Transactional
    @Query("select res.id from RestaurantEntity res where LOWER(res.nameRestaurant) = LOWER(:nameRestaurant)")
    UUID getIdByName (@Param("nameRestaurant") String nameRestaurant);

    //////////////////////////Поиск id блюда по его названию///////////////////////////////
    @Transactional
    @Query("select res.id from RestauranMenuItemsEntity res where res.restauranId = :restauranId AND LOWER(res.nameItems) = LOWER(:nameItems)")
    UUID getIdByMenuName (@Param("restauranId") UUID restauranId,
                           @Param("nameItems") String nameItems);

    //////////////////////////Изменение стоимости блюда по Id блюда ///////////////////////////////
    @Modifying
    @Transactional
    @Query("update RestauranMenuItemsEntity res set res.price = :price where res.id = :id")
    void updatePriceRestauranMenuItem (@Param("id") UUID id,
                                       @Param("price") BigDecimal price);
}


