package ru.liga.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.liga.entities.CustomersEntity;
import ru.liga.entities.OrdersEntity;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersEntity,Long> {

    CustomersEntity findCustomersById(long id);
    CustomersEntity findCustomerByPhone(String phone);


}

