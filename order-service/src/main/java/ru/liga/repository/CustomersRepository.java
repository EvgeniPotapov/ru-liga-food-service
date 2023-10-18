package ru.liga.repository;

import org.springframework.data.repository.CrudRepository;
import ru.liga.entities.CustomersEntity;

public interface CustomersRepository extends CrudRepository<CustomersEntity,Long> {

    CustomersEntity findCustomersById(long id);

    CustomersEntity findCustomersByPhone(String phone);
}
