package ru.liga.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "restauran_menu_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class RestauranMenuItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "restauran_id")
//    private RestaurantEntity restaurant;
    @Column(name = "restauran_id")
    private long restaurantId;

    @Column(name = "nameitems")
    private String name;

    private BigDecimal price;

    private String image;

    private String description;
}
