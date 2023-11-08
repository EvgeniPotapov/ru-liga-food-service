package ru.liga.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "orders_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "order_id")
    private UUID orderId;

    @Column(name = "restaurant_menu_item")
    private long restaurantMenuItemsId;

    private BigDecimal price;

    private int quantity;


}
