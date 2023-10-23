package ru.liga.deliveryController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.CustomerAddressDto;
import ru.liga.dto.DeliveryDto;
import ru.liga.dto.MenuItemsOrderDto;
import ru.liga.dto.RestaurantAddressDto;
import ru.liga.entities.CouriersEntity;
import ru.liga.feignServise.FeignDelivery;
import ru.liga.repository.CouriersRepository;

@RestController
public class DeliveryController {
    @Autowired
    CouriersRepository couriersRepository;
    @Autowired
    FeignDelivery feignDelivery;

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

    @GetMapping("/deliv/{id}")
    public CouriersEntity getCour (@PathVariable ("id") long id){

      CouriersEntity couriersEntity =  couriersRepository.findCouriersById(id);
        return couriersEntity;
    }

    //Запрос на получение заказа клиента по id в модуль кухни
    @GetMapping("/getOrderItem/{id}")
    public MenuItemsOrderDto getOrder (@PathVariable long id){

        return feignDelivery.getOrderItem(id);
    }
}
