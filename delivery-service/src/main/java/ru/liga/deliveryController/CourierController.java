package ru.liga.deliveryController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.CouriersDto;
import ru.liga.dto.OrderDto;
import ru.liga.services.CouriersServices;
import ru.liga.services.OrderServices;

import java.util.UUID;


@RestController
@RequestMapping("/delivery")
public class CourierController {
    @Autowired
    CouriersServices couriersServices;
    @Autowired
    OrderServices orderServices;

    ////////////////////////////////////////// Получение заказа ///////////////////////////////////////////////////////
    @GetMapping("/order/{id}")
    public OrderDto getOrderById (@PathVariable UUID id){

        return orderServices.getOrder(id);
    }

    ////////////////////////////////////////// Изменение статуса заказа //////////////////////////////////////////
    @PutMapping("/{id}/{status}")
    public void updateOrderStatusComplete (@PathVariable UUID id,@PathVariable String status){

        orderServices.updateOrderById(id,status);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////    Контроллеры для работы с курьером        /////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //////////////////////////////////////////Добавление курьера в базу данных//////////////////////////////////////////
    @PostMapping("/couriers/save")
    public void addCouriers(@RequestBody CouriersDto couriersDto){

        couriersServices.saveCouriers(couriersDto);
    }

    //////////////////////////////////////////Удаление курьера из базы данных//////////////////////////////////////////
    @DeleteMapping("/couriers/delete/{id}")
    public void deleteCouriers(@PathVariable long id){

        couriersServices.deleteCouriers(id);
    }

    //////////////////////////////////////////Изменение статуса курьера//////////////////////////////////////////
    @PutMapping("/couriers/update/{id}/{status}")
    public void updateStatusCouriers(@PathVariable long id,@PathVariable String status){

        couriersServices.updateCouriers(id, status);
    }
}
