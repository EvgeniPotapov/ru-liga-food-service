package ru.liga.deliveryController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.CustomerAddressDto;
import ru.liga.dto.DeliveryDto;
import ru.liga.dto.RestaurantAddressDto;
import ru.liga.entities.CouriersEntity;
import ru.liga.repository.CouriersRepository;

@RestController
public class DeliveryController {
     @Autowired
     CouriersRepository couriersRepository;

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



    @GetMapping("/couriers/id/{phone}")
    public CouriersEntity couriersBy (@PathVariable String phone){

        CouriersEntity couriersEntity = couriersRepository.findCouriersByPhone(phone);

        return couriersEntity;
    }
}
