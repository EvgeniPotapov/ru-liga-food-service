package ru.liga.kitchenController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.dto.RequestMenu_itemsDto;
import ru.liga.dto.ResponseOrderItemDto;

@RestController
public class KitchenController {

    @GetMapping("/order/{status}")
    @ResponseBody
    public ResponseOrderItemDto orerInfo(@PathVariable("status") String status){

       ResponseOrderItemDto responseOrderItemDto = new ResponseOrderItemDto();
       responseOrderItemDto.setMenu_items(new RequestMenu_itemsDto());

        return responseOrderItemDto ;
    }

}
