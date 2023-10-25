package ru.liga.orderController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.myBatis.CustomerMapper;
import ru.liga.myBatis.OrdersMapper;
import ru.liga.orderDto.CustomerDto;
import ru.liga.orderDto.OrderDto;

@RestController
@RequestMapping("myBatis")
public class MyBatisController {
    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    OrdersMapper ordersMapper;

    ////////////////////////////////////////////////////////
    //////////////////Customer//////////////////////////////

    @GetMapping("customerId/{id}")
    CustomerDto customerById (@PathVariable long id){
        return customerMapper.getCustomerById(id);
    }

    @GetMapping("customerPhone/{phone}")
    CustomerDto customerByPhone (@PathVariable String phone){
        return customerMapper.getCustomerByPhone(phone);
    }

    ////////////////////////////////////////////////////////
    ////////////////////Order//////////////////////////////

    @GetMapping("orderId/{id}")
    OrderDto orderById (@PathVariable long id){
        return ordersMapper.getOrderById(id);
    }

    @GetMapping("orderStatus/{status}")
    OrderDto orderByStatus (@PathVariable String status){

        return ordersMapper.getOrderByStatus(status);
    }
}
