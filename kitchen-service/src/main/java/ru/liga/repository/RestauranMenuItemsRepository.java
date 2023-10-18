package ru.liga.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.liga.entities.RestauranMenuItemsEntity;

@Repository
public interface RestauranMenuItemsRepository extends CrudRepository<RestauranMenuItemsEntity, Long > {

    RestauranMenuItemsEntity findRestauranMenuItemsById(long id);

    RestauranMenuItemsEntity findRestauranMenuItemsByName(String name);


}
