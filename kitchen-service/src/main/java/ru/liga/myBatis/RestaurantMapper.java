package ru.liga.myBatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.liga.dto.RestaurantDto;
@Mapper
public interface RestaurantMapper {

    @Select("select * from restaurant res where res.id=#{id}")
    RestaurantDto getRestaurantById(long id);

    @Select("select * from restaurant res where res.address=#{address}")
    RestaurantDto getRestaurantByAddress(String address);
}
