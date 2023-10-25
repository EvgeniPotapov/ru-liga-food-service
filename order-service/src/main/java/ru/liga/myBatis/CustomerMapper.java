package ru.liga.myBatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import ru.liga.orderDto.CustomerDto;


@Mapper
public interface CustomerMapper {

    @Select("select * from customers cus where cus.id=#{id}")
    CustomerDto getCustomerById(long id);
    @Select("select * from customers cus where cus.phone=#{phone}")
    CustomerDto getCustomerByPhone(String phone);
}
