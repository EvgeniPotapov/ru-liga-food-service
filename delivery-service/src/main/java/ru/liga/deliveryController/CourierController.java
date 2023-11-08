package ru.liga.deliveryController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.dto.OrderDto;
import ru.liga.services.CouriersServices;


import java.util.List;
import java.util.UUID;


@RestController
public class CourierController {
    @Autowired
    CouriersServices couriersServices;

    @GetMapping("/delivery")
    public List<OrderDto> getOrderById (){

        return couriersServices.getOrders();
    }

    @PutMapping("/delivery/{id}/take")
    public void updateOrderStatusTake (@PathVariable UUID id){

        String status = "take";
        couriersServices.updateOrderById(id,status);
    }

    @PutMapping("/delivery/{id}/complete")
    public void updateOrderStatusComplete (@PathVariable UUID id){

        String status = "complete";
        couriersServices.updateOrderById(id,status);
    }
}
