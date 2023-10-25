package ru.liga.myBatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import ru.liga.orderDto.OrderDto;

@Mapper
public interface OrdersMapper {
    @Results(value = {
            @Result(property = "customerId", column = "customer_id"),
            @Result(property = "restauranId", column = "restauran_id"),
            @Result(property = "courierId", column = "courier_id"),
            @Result(property = "timeStamp", column = "time_stamp")
    })
    @Select("select * from orders ord where ord.id=#{id}")
    OrderDto getOrderById(long id);
    @Results(value = {
            @Result(property = "customerId", column = "customer_id"),
            @Result(property = "restauranId", column = "restauran_id"),
            @Result(property = "courierId", column = "courier_id"),
            @Result(property = "timeStamp", column = "time_stamp")
    })
    @Select("select * from orders ord where ord.status=#{status}")
    OrderDto getOrderByStatus(String status);
}
