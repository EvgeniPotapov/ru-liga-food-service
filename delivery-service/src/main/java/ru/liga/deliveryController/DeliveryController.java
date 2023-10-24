package ru.liga.deliveryController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.*;
import ru.liga.entities.CouriersEntity;
import ru.liga.feignServise.FeignDelivery;
import ru.liga.repository.CouriersRepository;
import ru.liga.services.CouriersServices;

@RestController
public class DeliveryController {
    @Autowired
    CouriersServices couriersServices;
    @Autowired
    FeignDelivery feignDelivery;

    //Получение информации о расстоянии до ресторана и клиента
    @GetMapping("/deliveriesInfo/{status}")
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

    //Запрос на получение заказа клиента по id в модуль кухни
    @GetMapping("/orderItem/{id}")
    public MenuItemsOrderDto getOrder (@PathVariable long id){

        return feignDelivery.getOrderItem(id);
    }

    /////////////////////////////////////////
    /////////////Couriers///////////////////

    //Получение информации о курьере по Id
    @GetMapping("/couriers/{id}")
    public CouriersDto couriersId (@PathVariable long id){

        return couriersServices.getCouriersId(id);
    }

    //Получение курьера по телефону
    @GetMapping("/couriers/phone/{phone}")
    public CouriersDto couriersPhone (@PathVariable String phone){

        return couriersServices.getCouriersPhone(phone);
    }
}
