package ru.liga.feignServise;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.liga.dto.MenuItemsOrderDto;

@FeignClient(value = "feignDelivery", url = "http://localhost:8081")
public interface FeignDelivery {

    @GetMapping("/getOrderItem/{id}")
    MenuItemsOrderDto getOrderItem (@PathVariable long id);
}
