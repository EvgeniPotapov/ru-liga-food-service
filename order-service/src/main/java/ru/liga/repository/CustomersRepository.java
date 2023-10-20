package ru.liga.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.liga.entities.CustomersEntity;
@Repository
public interface CustomersRepository extends CrudRepository<CustomersEntity,Long> {

    CustomersEntity findCustomersById(long id);


}

