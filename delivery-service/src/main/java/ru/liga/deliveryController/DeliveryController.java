package ru.liga.deliveryController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.*;
import ru.liga.entities.CouriersEntity;
import ru.liga.feignServise.FeignDelivery;
import ru.liga.repository.CouriersRepository;

@RestController
public class DeliveryController {
    @Autowired
    CouriersRepository couriersRepository;
    @Autowired
    FeignDelivery feignDelivery;

    //Получение информации о расстоянии до ресторана и клиента
    @GetMapping("/deliveries/{status}")
    public InformationToCouriersDto getAddress (@PathVariable ("status") String status){

        InformationToCouriersDto informationToCouriersDto = new InformationToCouriersDto();
        informationToCouriersDto.setRestaurant(new RestaurantAddress());
        informationToCouriersDto.setCustomer(new CustomerAddress());

        return informationToCouriersDto;
    }

    //Получение статуса заказа
    @PostMapping("delivery/{id}")
    public void getStatusOrder (@PathVariable long id, @RequestBody String orderAction){

    }

    //Получение информации о курьере по Id
    @GetMapping("/couriers/{id}")
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
