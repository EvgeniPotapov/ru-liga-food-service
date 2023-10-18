package ru.liga.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class OrderItemsEntity {

    @Id
    private long id;

    @Column(name = "order_id")
    private long orderId;

    @Column(name = "restaurant_menu_item")
    private long restaurantMenuItems;

    private BigDecimal price;

    private int quantitu;

}
