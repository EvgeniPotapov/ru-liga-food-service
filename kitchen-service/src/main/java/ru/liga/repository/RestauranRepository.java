package ru.liga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.liga.entities.RestaurantEntity;
@Repository
public interface RestauranRepository extends CrudRepository<RestaurantEntity, Long> {

    RestaurantEntity findRestaurantById(long id);

    RestaurantEntity findRestaurantByStatus(String status);
}
