package ru.liga.orderController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.orderDto.MenuItems;
import ru.liga.orderDto.RestoranName;
import ru.liga.orderDto.*;
import ru.liga.services.CustomerServices;
import ru.liga.services.OrderServices;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    CustomerServices customerServices;
    @Autowired
    OrderServices orderServices;

    @GetMapping("/articles")
    public String[] getArticles() {
        return new String[] { "Article 1", "Article 2", "Article 3" };
    }

    //получение списка всех заказов
    @GetMapping("/ordersMenu")
    public List<OrderMenuDto> getOrder (){

        List <OrderMenuDto> orders= new ArrayList<>();

        OrderMenuDto orderMenuDto = new OrderMenuDto();
        orderMenuDto.setItems(new MenuItems());
        orderMenuDto.setRestaurant(new RestoranName());
       orders.add(orderMenuDto);

        return orders ;
    }

        //получение заказа по Id
        @GetMapping("/orderMenu/{id}")
        public OrderMenuDto getOrderMenuById (@PathVariable("id") long id){

               OrderMenuDto orderMenuDto = new OrderMenuDto();
            orderMenuDto.setId(id);
            orderMenuDto.setItems(new MenuItems());
            orderMenuDto.setTimestamp(30);
            orderMenuDto.setRestaurant(new RestoranName());

            return orderMenuDto;
        }

     //оплата заказа
    @PostMapping("/order/payment")
    public PaymentToOrderDto paymentOrder (@PathVariable("id") long id, @RequestBody MenuRestoran menuRestoran){

        return new PaymentToOrderDto() ;
    }

    //////////////////////////////////////
    //////////////Customer///////////////

    //получение клиента по Id
    @GetMapping("/customer/{id}")
    public CustomerDto customerById (@PathVariable long id){

        return customerServices.getCustomerId(id);
    }

    //получение клиента по номеру телефона
    @GetMapping("customer/phone/{phone}")
    public  CustomerDto customerByPhone(@PathVariable String phone){

        return customerServices.getCustomerPhone(phone);
    }

    ////////////////////////////////////////////////////////
    /////////////////Order/////////////////////////////////


    //получение заказа по id
    @GetMapping("order/{id}")
    public OrderDto orderById(@PathVariable long id){

        return orderServices.getOrderId(id);
    }

    //получение заказа по статусу
    @GetMapping("order/status/{status}")
    public OrderDto orderById(@PathVariable String status){

        return orderServices.detOrderStatus(status);
    }



}
