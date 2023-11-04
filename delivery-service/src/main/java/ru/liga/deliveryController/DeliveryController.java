package ru.liga.deliveryController;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.dto.*;
import ru.liga.feignServise.FeignDelivery;
import ru.liga.myBatis.CouriersMapper;
import ru.liga.services.CouriersServices;
@Tag(name = "API для взаимодействия с delivery-service")
@RestController
public class DeliveryController {

    @Autowired
    private FeignDelivery feignDelivery;
    @Autowired
    private CouriersMapper couriersMapper;


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

    ///////////////////////////////////////////////////
    ////////////////////MyBatis///////////////////////

    //Поиск курьера по id
    @Operation(summary = "поиск курьера по id через myBatis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Данные получены"),
            @ApiResponse(responseCode = "404", description = "Данные не найдены")
    })
    @GetMapping("/myBatisId/{id}")
    public CouriersDto couriersMeBatisId (@PathVariable long id){

        return couriersMapper.getCouriersById(id);
    }

    //Поиск курьера по статусу
    @Operation(summary = "поиск курьера по номеру телефона через myBatis")
    @GetMapping("/myBatis/{status}")
    public CouriersDto couriersMeBatisStatus (@PathVariable String status){

        return couriersMapper.getCouriersByStatus(status);
    }
}
