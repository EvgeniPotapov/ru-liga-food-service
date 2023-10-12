package ru.liga.kitchenController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class KitchenController {

    @GetMapping("/orderItem")
    public String itemsToBasket(){

        return  "показ доступных заказов для работы";
    }


    @PutMapping("/orderItem/{status}")
    public String updateStatus(@PathVariable("status") String status){

        return  "Статус заказа изменён";
    }


}
