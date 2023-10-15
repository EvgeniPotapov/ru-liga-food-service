package ru.liga.deliveryController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class DeliveryController {

    @PutMapping("/orderItem/{status}")
    public String updateStatus(@PathVariable("status") String status){

        return  "Статус заказа изменён";
    }
}
