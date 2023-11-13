package ru.liga.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "restauran_menu_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestauranMenuItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "restauran_id")
    private UUID restauranId;

    @Column(name = "name_items")
    private String nameItems;

    private BigDecimal price;

    private String image;

    private String description;

}
