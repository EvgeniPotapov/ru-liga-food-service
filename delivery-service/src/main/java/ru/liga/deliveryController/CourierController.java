package ru.liga.deliveryController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.apache.ibatis.javassist.NotFoundException;
import org.springdoc.api.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.dto.CouriersDto;
import ru.liga.services.CouriersServices;

@RestController
public class CourierController {
    @Autowired
    CouriersServices couriersServices;

    /////////////////////////////////////////
    /////////////Couriers///////////////////

    //Получение информации о курьере по Id

    @Operation(summary = "поиск курьера по id")
    @GetMapping("/couriers/{id}")
    public CouriersDto couriersId (
            @Parameter(description = "уникальний идентификатор пользователя")
            @PathVariable long id){

        return couriersServices.getCouriersId(id);
    }

    //Получение курьера по телефону
    @Operation(summary = "поиск курьера по номеру телефона")
    @GetMapping("/couriers/phone/{phone}")
    public CouriersDto couriersPhone (@PathVariable String phone){

        return couriersServices.getCouriersPhone(phone);
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> handleException(NotFoundException notFoundException){
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(notFoundException.getMessage()));
    }
}
