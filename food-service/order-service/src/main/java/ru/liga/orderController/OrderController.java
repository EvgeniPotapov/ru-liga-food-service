package ru.liga.orderController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.liga.orderDto.Orders;

@Controller
public class OrderController {


        @GetMapping("/registration")
        public String registration (){

            return "форма регистрации пользователя";
        }
        @PostMapping("/registration")
        public void addUser (){

            //Добавление пользователя в базу данных
        }

        @GetMapping("/restaurant")
        public String restaurant (){

            return "выдаём списак доступных ресторвнов";
        }
        @GetMapping("/restaurant/{id}")
        public String menuRestaurant(@PathVariable("id") long id){

            return "выдаём меню в зависимости от выбранного ресторана";
        }
        @PostMapping("/restaurant/menu/{id}")
        public void addItemsToBasket(@PathVariable("id") long id){

            //реализация добавления товаров в корзину
        }

        @DeleteMapping("/restaurant/menu/{id}")
        public void deleteItemsToBasket(@PathVariable("id") long id){

            //реализация удаления товаров из корзины
        }

        @PutMapping("/restaurant/menu/{id}")
        public void updateItemsToBasket(@PathVariable("id") long id){

            //реализация редактирования товаров в корзине
        }

        @GetMapping("/basket/{id}")
        public String itemsToBasket(@PathVariable("id")long id){

            return  "Вывод всех товаров из корзины закрепленных за пользователем";
        }
        @PostMapping("/create")
        public String createOrder (@RequestBody Orders orders){

            //Создание заказа
                return "новый заказ создан";
        }


}
