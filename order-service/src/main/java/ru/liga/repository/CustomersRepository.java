package ru.liga.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.entities.CustomersEntity;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersEntity,Long> {

    CustomersEntity findCustomersById(long id);
    CustomersEntity findCustomerByPhone(String phone);


}

