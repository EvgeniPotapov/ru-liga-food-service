package ru.liga.deliveryController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.CustomerAddressDto;
import ru.liga.dto.DeliveryDto;
import ru.liga.dto.RestaurantAddressDto;

@RestController
public class DeliveryController {

    @GetMapping("/deliveries/{status}")
    public DeliveryDto getAddress (@PathVariable ("status") String status){

        DeliveryDto dto = new DeliveryDto();
        dto.setRestaurant(new RestaurantAddressDto());
        dto.setCustomer(new CustomerAddressDto());

        return dto;
    }

    @PostMapping ("/delivery/{id}")
    public String setStatus (@PathVariable ("id") long id, @RequestParam("order_action")
    String order_action){



        return "статус изменён";
    }
}
