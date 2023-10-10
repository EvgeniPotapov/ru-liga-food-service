package ru.liga.dao;

import org.springframework.stereotype.Component;
import ru.liga.models.Order;


import java.util.ArrayList;
import java.util.List;
@Component
public class OrderDao {

    OrderDao orderDao ;
    private static int PEOPLE_COUNT;
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order){

        order.setId(PEOPLE_COUNT++);
        orders.add(order);
    }

    public Order searchOrderById(long id){

        return  orders.stream().filter(order -> order.getId()==id).findAny().orElse(null);
    }

    public void setOrdersById (long id,String status){

        orderDao=new OrderDao();
       Order order = orderDao.searchOrderById(id);

       order.setStatus(status);
    }

    public void delitOrderById(long id){

        orders.stream().filter(order -> order.getId()==id).iterator().remove();


    }



}
