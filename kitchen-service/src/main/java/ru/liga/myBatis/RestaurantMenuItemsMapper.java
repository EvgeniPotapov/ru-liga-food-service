package ru.liga.myBatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.liga.dto.RestauranMenuItemsDto;
import java.math.BigDecimal;

@Mapper
public interface RestaurantMenuItemsMapper {
    @Results(value = {
            @Result(property = "name", column = "nameitems")})
    @Select("select * from restauran_menu_items res where res.id=#{id}")
    RestauranMenuItemsDto getRestaurantById(long id);

    @Results(value = {
            @Result(property = "name", column = "nameitems")})
    @Select("select * from restauran_menu_items res where res.price=#{price}")
    RestauranMenuItemsDto getRestaurantByPrice(BigDecimal price);
}
