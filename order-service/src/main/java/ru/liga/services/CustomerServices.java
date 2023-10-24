package ru.liga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.liga.entities.CustomersEntity;
import ru.liga.mappers.CustomerMappers;
import ru.liga.orderDto.CustomerDto;
import ru.liga.repository.CustomersRepository;
@Service
public class CustomerServices  {
    @Autowired
    CustomersRepository customersRepository;
    @Autowired
    CustomerMappers customerMappers;
    public CustomerDto getCustomerId (long id){

        CustomersEntity customersEntity = customersRepository.findCustomersById(id);
        CustomerDto customerDto = customerMappers.entityToDto(customersEntity);

        return customerDto;

    }

    public CustomerDto getCustomerPhone (String phone){

        CustomersEntity customersEntity = customersRepository.findCustomerByPhone(phone);
        CustomerDto customerDto = customerMappers.entityToDto(customersEntity);

        return customerDto;

    }






}
