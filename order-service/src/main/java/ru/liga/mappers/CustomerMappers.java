package ru.liga.mappers;

import org.mapstruct.Mapper;
import ru.liga.entities.CustomersEntity;
import ru.liga.orderDto.CustomerDto;


@Mapper(componentModel = "spring")
public interface CustomerMappers {

    CustomersEntity dtoToEntity (CustomerDto customerDto);

    CustomerDto entityToDto (CustomersEntity customersEntity);


}
