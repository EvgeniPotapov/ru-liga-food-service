package ru.liga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.dao.OrderDao;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final OrderDao orderDao;

    @Autowired
    public DeliveryController (OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @PatchMapping("{id}")
    public String setOrder (@PathVariable("id") long id, @PathVariable("status") String status){
        orderDao.setOrdersById(id, status);
        return "Объект изменён";

    }
}
