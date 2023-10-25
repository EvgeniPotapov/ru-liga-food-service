package ru.liga.myBatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.liga.dto.CouriersDto;
@Mapper
public interface CouriersMapper {

    @Select("select * from couriers cor where cor.status=#{status}")
    CouriersDto getCouriersByStatus(String status);

    @Select("select * from couriers cor where cor.id=#{id}")
    CouriersDto getCouriersById(long id);

}
