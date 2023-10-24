package ru.liga.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.liga.entities.RestauranMenuItemsEntity;

import javax.transaction.Transactional;
import java.math.BigDecimal;

//Выполнение запросов к базе данных (меню ресторана)
@Repository
public interface RestauranMenuItemsRepository extends CrudRepository<RestauranMenuItemsEntity, Long > {

    RestauranMenuItemsEntity findRestauranMenuItemsById(long id);

    RestauranMenuItemsEntity findRestauranMenuItemsByName(String name);

    RestauranMenuItemsEntity save (RestauranMenuItemsEntity restauranMenuItemsEntity);

    void deleteById(long id);
    @Modifying
    @Transactional
    @Query("update RestauranMenuItemsEntity res set res.price = :price where res.id = :id")
    void updatePriceMenu (@Param("id")long id, @Param("price")BigDecimal price);

}






