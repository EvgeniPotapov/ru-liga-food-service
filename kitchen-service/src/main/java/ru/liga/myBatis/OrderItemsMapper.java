package ru.liga.myBatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.liga.dto.MenuItemsOrderDto;

import java.math.BigDecimal;

@Mapper
public interface OrderItemsMapper {

    @Select("select * from order_items ord where ord.id=#{id}")
    MenuItemsOrderDto getOrderItemById(long id);

    @Select("select * from order_items ord where ord.price=#{price}")
    MenuItemsOrderDto getOrderItemByPrice(BigDecimal price);
}
