package ru.liga.mappers;

import org.mapstruct.Mapper;
import ru.liga.dto.CouriersDto;
import ru.liga.entities.CouriersEntity;

@Mapper(componentModel = "spring")
public interface CourierMappers {

    CouriersEntity dtoToEntity (CouriersDto couriersDto);

    CouriersDto entityToDto (CouriersEntity couriersEntity);
}
